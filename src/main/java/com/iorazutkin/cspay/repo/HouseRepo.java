package com.iorazutkin.cspay.repo;

import com.iorazutkin.cspay.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepo extends JpaRepository<House, Long> {
    House findByCityAndStreetAndHouse(String city, String street, String house);
}
