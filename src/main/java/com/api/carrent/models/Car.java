package com.api.carrent.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "car")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private Date checkin;
    @Column
    private Date checkout;
    @Column
    private Double valueInitial;
    @OneToOne
    @JoinColumn(name = "id_rent")
    private Rent rent;

    public Car(){
    }

    public Car(Long id, String brand, String model, Date checkin, Date checkout, Double valueInitial, Rent rent) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.checkin = checkin;
        this.checkout = checkout;
        this.valueInitial = valueInitial;
        this.rent = rent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Double getValueInitial() {
        return valueInitial;
    }

    public void setValueInitial(Double valueInitial) {
        this.valueInitial = valueInitial;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
