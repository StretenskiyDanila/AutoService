package ru.stretenskiy.autoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entities.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {
}
