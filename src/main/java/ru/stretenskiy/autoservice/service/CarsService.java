package ru.stretenskiy.autoservice.service;

import ru.stretenskiy.autoservice.entity.Car;

import java.util.List;

public interface CarsService {

    void addCars(Car car);

    Car getCarById(Long id);

    List<Car> getCars();

}
