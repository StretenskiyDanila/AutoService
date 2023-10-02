package ru.stretenskiy.autoservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.stretenskiy.autoservice.entity.Servicing;
import ru.stretenskiy.autoservice.repository.ServicingRepository;
import ru.stretenskiy.autoservice.service.ServicingService;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServicingServiceImpl implements ServicingService {

    @Autowired
    private ServicingRepository servicingRepository;

    @Override
    public void addServices(Servicing servicing) {
        servicingRepository.save(servicing);
    }

    @Override
    public Servicing getServiceById(Long id) {
        return servicingRepository.findById(id).orElse(null);
    }

    @Override
    public Servicing getServiceByName(String servicingName) {
        return servicingRepository.findByName(servicingName).orElse(null);
    }

    @Override
    public List<Servicing> getServicing() {
        return servicingRepository.findAll();
    }
}
