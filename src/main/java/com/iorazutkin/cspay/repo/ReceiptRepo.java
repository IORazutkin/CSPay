package com.iorazutkin.cspay.repo;

import com.iorazutkin.cspay.domain.Apartment;
import com.iorazutkin.cspay.domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiptRepo extends JpaRepository<Receipt, Long> {
    Receipt findLastByApartmentAndPayDateIsNull(Apartment apartment);
    Receipt findLastByApartmentAndPayDateIsNotNull(Apartment apartment);
    List<Receipt> findLast12ByApartmentAndPayDateIsNotNull(Apartment apartment);
}