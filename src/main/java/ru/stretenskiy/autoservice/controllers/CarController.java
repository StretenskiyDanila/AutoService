package ru.stretenskiy.autoservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stretenskiy.autoservice.dto.CarDTO;
import ru.stretenskiy.autoservice.entities.Car;
import ru.stretenskiy.autoservice.services.CarService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping()
    public ResponseEntity<List<CarDTO>> getAllCar() {
        List<Car> carList = carService.getAllCar();
        return ResponseEntity.ok(carList.stream().map(CarDTO::buildCarDTO).collect(Collectors.toList()));
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();

        car.setNumber(carDTO.getNumber());
        car.setColor(carDTO.getColor());
        car.setMark(carDTO.getMark());
        car.setIsForeign(carDTO.getIsForeign());

        try {
            return ResponseEntity.ok(carService.saveCar(car));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<Long> updateCar(@RequestBody CarDTO carDTO) {
        Optional<Car> carOpt =  carService.getCarById(carDTO.getId());
        if (carOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Car car = carOpt.get();
        car.setId(carDTO.getId());
        car.setNumber(carDTO.getNumber());
        car.setColor(carDTO.getColor());
        car.setMark(carDTO.getMark());
        car.setIsForeign(carDTO.getIsForeign());
        try {
            return ResponseEntity.ok(carService.saveCar(car));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteCar(@RequestParam(name = "id") Long id) {
        Optional<Car> deleteCarOpt = carService.getCarById(id);
        if (deleteCarOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
        try {

            carService.deleteCar(deleteCarOpt.get());
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

}
