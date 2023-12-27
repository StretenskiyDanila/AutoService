package ru.stretenskiy.autoservice.services;

import ru.stretenskiy.autoservice.entities.Servicing;

import java.util.List;
import java.util.Optional;

public interface ServicingService {

    List<Servicing> getAllServices();

    Long saveServicing(Servicing servicing);

    void deleteServicing(Servicing service);

    Optional<Servicing> getServicingById(Long id);

}
