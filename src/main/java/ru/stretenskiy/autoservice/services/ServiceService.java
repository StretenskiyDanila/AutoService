package ru.stretenskiy.autoservice.services;

import ru.stretenskiy.autoservice.entities.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {

    List<Service> getAllServices();

    Long saveService(Service service);

    void deleteService(Service service);

    Optional<Service> getServiceById(Long id);

}
