package com.iorazutkin.cspay.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private LocalDate date;
    private String cvv;

    public Card() {}

    public Card(String number, LocalDate date, String cvv) {
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
