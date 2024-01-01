package ru.stretenskiy.autoservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entities.Car;
import ru.stretenskiy.autoservice.entities.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

    @Query(value = "SELECT * FROM works p ORDER BY id", nativeQuery = true)
    Page<Car> loadListOfWorks(Pageable pageable);

}
