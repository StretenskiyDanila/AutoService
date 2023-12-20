package ru.stretenskiy.autoservice.services.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.Service;
import ru.stretenskiy.autoservice.services.ServiceService;

import java.util.List;
import java.util.Optional;

public class ServiceServiceImpl implements ServiceService {

    @Override
    public List<Service> getAllServices() {
        return null;
    }

    @Override
    @Transactional
    public Long saveService(Service service) {
        return null;
    }

    @Override
    @Transactional
    public void deleteService(Service service) {

    }

    @Override
    public Optional<Service> getServiceById(Long id) {
        return Optional.empty();
    }

}
