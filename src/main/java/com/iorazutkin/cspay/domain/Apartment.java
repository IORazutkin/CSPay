package com.iorazutkin.cspay.domain;

import javax.persistence.*;

@Entity
@Table
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer number;
    @ManyToOne
    @JoinColumn(name = "houseId")
    private House houseId;

    public Apartment() { }

    public Apartment(Integer number, House houseId) {
        this.number = number;
        this.houseId = houseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public House getHouseId() {
        return houseId;
    }

    public void setHouseId(House houseId) {
        this.houseId = houseId;
    }
}
