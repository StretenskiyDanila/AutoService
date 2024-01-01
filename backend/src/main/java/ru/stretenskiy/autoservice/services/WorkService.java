package ru.stretenskiy.autoservice.services;

import org.springframework.core.io.ByteArrayResource;
import ru.stretenskiy.autoservice.entities.Work;

import java.util.List;
import java.util.Optional;

public interface WorkService {

    List<Work> getAllWorks();

    Long saveWork(Work work);

    void deleteWork(Work work);

    Optional<Work> getWorkById(Long id);

    ByteArrayResource generateReport();

}
