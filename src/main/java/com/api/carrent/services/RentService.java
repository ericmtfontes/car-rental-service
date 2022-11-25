package com.api.carrent.services;

import com.api.carrent.models.Car;
import com.api.carrent.models.Rent;

public class RentService {

    private TaxService taxService;

    public RentService(){
    }

    public RentService(TaxService taxService){
        this.taxService = taxService;
    }

    public Rent processRent(Car car){
        long checkin = car.getCheckin().getTime();
        long checkout = car.getCheckout().getTime();

        long difference = (checkout - checkin) / 1000 / 60 / 60 / 24;

        int days = Math.round(difference);

        double totalValue = car.getValueInitial();

        for(int i = 1; i <= days; i++){
            totalValue += taxService.tax(car.getValueInitial());
        }

        Rent rent = new Rent(null, car.getCheckin(), totalValue);

        return rent;

    }
}
