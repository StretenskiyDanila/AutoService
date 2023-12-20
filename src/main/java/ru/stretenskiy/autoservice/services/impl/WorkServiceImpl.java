package ru.stretenskiy.autoservice.services.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.Work;
import ru.stretenskiy.autoservice.services.WorkService;

import java.util.List;
import java.util.Optional;

public class WorkServiceImpl implements WorkService {

    @Override
    public List<Work> getAllWorks() {
        return null;
    }

    @Override
    @Transactional
    public Long saveWork(Work work) {
        return null;
    }

    @Override
    @Transactional
    public void deleteWork(Work work) {

    }

    @Override
    public Optional<Work> getWorkById(Long id) {
        return Optional.empty();
    }

}
