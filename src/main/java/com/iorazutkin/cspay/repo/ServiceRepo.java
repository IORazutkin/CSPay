package com.iorazutkin.cspay.repo;

import com.iorazutkin.cspay.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service, Long> {

}
