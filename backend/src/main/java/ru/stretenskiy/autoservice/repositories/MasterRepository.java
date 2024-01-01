package ru.stretenskiy.autoservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entities.Car;
import ru.stretenskiy.autoservice.entities.Master;

import java.sql.Date;
import java.util.List;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {

    @Query(value = "SELECT * FROM masters p ORDER BY id", nativeQuery = true)
    Page<Car> loadListOfMasters(Pageable pageable);

    @Query(value = "SELECT id FROM find_best_master(?1, ?2)", nativeQuery = true)
    List<Long> getBestMasters(Date withDate, Date beforeDate);

}
