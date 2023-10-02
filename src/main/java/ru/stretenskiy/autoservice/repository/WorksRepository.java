package ru.stretenskiy.autoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entity.Work;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorksRepository extends JpaRepository<Work, Long> {

    List<Work> findByServicingId(Long servicingId);
    List<Work> findByMasterId(Long masterId);
    List<Work> findByCarId(Long carId);

}
