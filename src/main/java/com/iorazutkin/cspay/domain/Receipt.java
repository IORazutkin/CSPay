package com.iorazutkin.cspay.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "apartmentId")
    private Apartment apartment;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiptServicesId")
    private List<ReceiptService> receiptServices;
    private LocalDate formationDate;
    private LocalDate payDate;

    public Receipt() {}

    public Receipt(Apartment apartment, LocalDate formationDate) {
        this.apartment = apartment;
        this.formationDate = formationDate;

        receiptServices = new ArrayList<>();
    }

    public void addReceiptService(ReceiptService receiptService) {
        receiptServices.add(receiptService);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public List<ReceiptService> getReceiptServices() {
        return receiptServices;
    }

    public void setReceiptServices(List<ReceiptService> receiptServices) {
        this.receiptServices = receiptServices;
    }

    public LocalDate getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(LocalDate formationDate) {
        this.formationDate = formationDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }
}
