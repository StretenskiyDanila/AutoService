package ru.stretenskiy.autoservice.services.impl;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.Servicing;
import ru.stretenskiy.autoservice.repositories.ServicingRepository;
import ru.stretenskiy.autoservice.services.ServicingService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicingServiceImpl implements ServicingService {

    private final ServicingRepository servicingRepository;

    @Override
    public List<Servicing> getAllServices() {
        return servicingRepository.findAll();
    }

    @Override
    @Transactional
    public Long saveServicing(@NotNull Servicing servicing) {
        log.info("Saving new {}", servicing);
        return servicingRepository.save(servicing).getId();
    }

    @Override
    @Transactional
    public void deleteServicing(@NotNull Servicing servicing) {
        log.info("Delete {}", servicing);
        servicingRepository.delete(servicing);
    }

    @Override
    public Optional<Servicing> getServicingById(@NotNull Long id) {
        return servicingRepository.findById(id);
    }


}
