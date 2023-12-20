package ru.stretenskiy.autoservice.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.dto.CarDTO;
import ru.stretenskiy.autoservice.entities.Car;
import ru.stretenskiy.autoservice.repositories.CarRepository;
import ru.stretenskiy.autoservice.services.CarService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public Long saveCar(@NotNull Car car) {
        log.info("Saving new {}", car);
        return carRepository.save(car).getId();
    }

    @Override
    @Transactional
    public void deleteCar(Car car) {
        log.info("Delete {}", car);
        carRepository.delete(car);
    }

    @Override
    public Optional<Car> getCarById(@NotNull Long id) {
        return carRepository.findById(id);
    }

}
