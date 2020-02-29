package com.iorazutkin.cspay.repo;

import com.iorazutkin.cspay.domain.Apartment;
import com.iorazutkin.cspay.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepo extends JpaRepository<Apartment, Long> {
    Apartment findByHouseAndNumber(House house, Integer number);
}
