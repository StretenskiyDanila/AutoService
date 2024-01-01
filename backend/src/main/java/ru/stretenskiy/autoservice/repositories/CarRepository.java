package ru.stretenskiy.autoservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;import ru.stretenskiy.autoservice.entities.Car;
import ru.stretenskiy.autoservice.utils.CostServices;

import java.sql.Date;
import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM cars p ORDER BY id", nativeQuery = true)
    Page<Car> loadListOfCars(Pageable pageable);

}
