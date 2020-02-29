package com.iorazutkin.cspay.repo;

import com.iorazutkin.cspay.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {
}
