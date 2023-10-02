package ru.stretenskiy.autoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stretenskiy.autoservice.entity.Master;

import java.util.Optional;

@Repository
public interface MasterRepository  extends JpaRepository<Master, Long> {

    Optional<Master> findByName(String name);

}
