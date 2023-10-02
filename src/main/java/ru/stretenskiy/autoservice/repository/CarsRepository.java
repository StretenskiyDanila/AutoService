package ru.stretenskiy.autoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entity.Car;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {
}
