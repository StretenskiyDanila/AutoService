package ru.stretenskiy.autoservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.stretenskiy.autoservice.entity.Car;
import ru.stretenskiy.autoservice.repository.CarsRepository;
import ru.stretenskiy.autoservice.service.CarsService;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Override
    public void addCars(Car car) {
        carsRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        return carsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> getCars() {
        return carsRepository.findAll();
    }
}
