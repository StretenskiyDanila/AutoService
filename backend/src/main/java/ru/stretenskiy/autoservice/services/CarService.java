package ru.stretenskiy.autoservice.services;

import org.springframework.core.io.ByteArrayResource;
import ru.stretenskiy.autoservice.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAllCar();

    Long saveCar(Car car);

    void deleteCar(Car car);

    Optional<Car> getCarById(Long id);

    ByteArrayResource generateReport();

}