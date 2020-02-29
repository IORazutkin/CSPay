package com.iorazutkin.cspay.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class ReceiptService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Service service;
    private LocalDate formationDate;
    private Float value;

    public ReceiptService() {}

    public ReceiptService(Service service, LocalDate formationDate, Float value) {
        this.service = service;
        this.formationDate = formationDate;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public LocalDate getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(LocalDate formationDate) {
        this.formationDate = formationDate;
    }
}