package com.iorazutkin.cspay.repo;

import com.iorazutkin.cspay.domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepo extends JpaRepository<Receipt, Long> {

}