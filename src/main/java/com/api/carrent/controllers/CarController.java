package com.api.carrent.controllers;

import com.api.carrent.models.Car;
import com.api.carrent.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class CarController {

    @Autowired
    CarService service;

    @GetMapping
    public List<Car> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Car findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Car create(@RequestBody Car car){
        return service.create(car);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
