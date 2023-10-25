package com.jmarques.CASESTUDY.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@RequiredArgsConstructor
public class Product {
    @Id
    private String id;

    private int vendorid;

    private String name;

    private BigDecimal costprice;

    private BigDecimal msrp;

    private int rop;

    private int eoq;

    private int qoh;

    private int qoo;

    private String qrcode;

    private String qrcodetxt;

}