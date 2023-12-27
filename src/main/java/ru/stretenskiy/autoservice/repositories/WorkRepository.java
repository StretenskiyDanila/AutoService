package ru.stretenskiy.autoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entities.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
}
