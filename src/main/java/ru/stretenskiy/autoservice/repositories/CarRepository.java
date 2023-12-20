package ru.stretenskiy.autoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Transactional
    @Modifying
    @Query("update Car c set c.number = ?1, c.color = ?2, c.mark = ?3, c.isForeign = ?4")
    int updateNumberAndColorAndMarkAndIsForeignBy(String number, String color, String mark, Integer isForeign);
}
