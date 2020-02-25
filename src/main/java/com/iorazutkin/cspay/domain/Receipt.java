package com.iorazutkin.cspay.domain;

import javax.persistence.*;

@Entity
@Table
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "apartmentId")
    private Apartment apartmentId;
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Service serviceId;
    private Float value;
    private Boolean payStatus = false;

    public Receipt() {}

    public Receipt(Apartment apartmentId, Service serviceId, Float value, Boolean payStatus) {
        this.apartmentId = apartmentId;
        this.serviceId = serviceId;
        this.value = value;
        this.payStatus = payStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apartment getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Apartment apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }
}
