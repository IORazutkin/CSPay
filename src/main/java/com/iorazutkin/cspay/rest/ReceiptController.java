package com.iorazutkin.cspay.rest;

import com.iorazutkin.cspay.domain.Receipt;
import com.iorazutkin.cspay.domain.ReceiptService;
import com.iorazutkin.cspay.domain.User;
import com.iorazutkin.cspay.repo.ReceiptRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    private ReceiptRepo receiptRepo;

    public ReceiptController(ReceiptRepo receiptRepo) {
        this.receiptRepo = receiptRepo;
    }

    @GetMapping
    public List<Receipt> getLast(@AuthenticationPrincipal User user) {
        List<Receipt> receipts = new ArrayList<>();
        receipts.add(receiptRepo.findLastByApartmentAndPayDateIsNull(user.getApartment()));
        receipts.add(receiptRepo.findLastByApartmentAndPayDateIsNotNull(user.getApartment()));
        return receipts;
    }

    @GetMapping("/stats")
    public List<Receipt> getLast12(@AuthenticationPrincipal User user) {
        return receiptRepo.findLast12ByApartmentAndPayDateIsNotNull(user.getApartment());
    }

    @PutMapping("/value")
    public Receipt updateLast(@AuthenticationPrincipal User user,
                              @RequestBody Receipt receipt) {
        Receipt receiptFromDb = receiptRepo.findLastByApartmentAndPayDateIsNull(user.getApartment());
        BeanUtils.copyProperties(receipt, receiptFromDb, "id");

        return receiptRepo.save(receiptFromDb);
    }

    @PutMapping("/pay")
    public List<Receipt> updatePay(@AuthenticationPrincipal User user) {
        List<Receipt> receipts = new ArrayList<>();
        Receipt receiptFromDb = receiptRepo.findLastByApartmentAndPayDateIsNull(user.getApartment());
        receiptFromDb.setPayDate(LocalDate.now());

        Receipt receipt = new Receipt(user.getApartment(), receiptFromDb.getFormationDate().plusMonths(1));
        receiptFromDb.getReceiptServices().forEach(item -> {
            receipt.addReceiptService(new ReceiptService(
                    item.getService(), item.getFormationDate(), item.getValue()));
        });

        receipts.add(receiptRepo.save(receipt));
        receipts.add(receiptRepo.save(receiptFromDb));

        return receipts;
    }
}
