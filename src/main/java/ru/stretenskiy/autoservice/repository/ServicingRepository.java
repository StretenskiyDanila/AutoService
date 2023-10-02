package ru.stretenskiy.autoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entity.Servicing;

import java.util.Optional;

@Repository
public interface ServicingRepository extends JpaRepository<Servicing, Long> {

    Optional<Servicing> findByName(String servicingName);

}
