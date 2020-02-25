package com.iorazutkin.cspay.repo;

import com.iorazutkin.cspay.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}