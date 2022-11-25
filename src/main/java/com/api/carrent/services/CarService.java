package com.api.carrent.services;

import com.api.carrent.handler.ResourceNotFoundException;
import com.api.carrent.models.Car;
import com.api.carrent.models.Rent;
import com.api.carrent.repositories.CarRepository;
import com.api.carrent.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;
    @Autowired
    RentRepository rentRepository;

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findById(Long id){
        return carRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("rent not found"));
    }

    public Car create(Car car){
        RentService rs = new RentService(new DailyTax());
        Rent rent = rs.processRent(car);
        rentRepository.save(rent);
        car.setRent(rent);
        return carRepository.save(car);
    }

    public void delete(Long id){
        Car car = carRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("rent not found"));
        Rent rent = rentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("rent not found"));

        carRepository.delete(car);
        rentRepository.delete(rent);
    }
}
