package com.iorazutkin.cspay.rest;

import com.iorazutkin.cspay.domain.Service;
import com.iorazutkin.cspay.repo.ServiceRepo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private ServiceRepo serviceRepo;

    public ServiceController(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    @GetMapping
    public List<Service> getList() {
        return serviceRepo.findAll(Sort.by("title"));
    }
}