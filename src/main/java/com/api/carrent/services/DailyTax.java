package com.api.carrent.services;

public class DailyTax implements TaxService{

    private static final Double taxRentEua = 0.10;

    @Override
    public Double tax(Double amount) {
        return amount * taxRentEua;
    }
}
