package ru.stretenskiy.autoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entities.Servicing;

@Repository
public interface ServicingRepository extends JpaRepository<Servicing, Long> {
}
