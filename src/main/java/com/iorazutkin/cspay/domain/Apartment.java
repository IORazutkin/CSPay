package com.iorazutkin.cspay.domain;

import javax.persistence.*;

@Entity
@Table
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "houseId")
    private House house;

    public Apartment() { }

    public Apartment(Integer number, House house) {
        this.number = number;
        this.house = house;
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

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
