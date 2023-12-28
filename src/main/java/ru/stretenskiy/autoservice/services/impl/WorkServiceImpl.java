package ru.stretenskiy.autoservice.services.impl;

import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.Work;
import ru.stretenskiy.autoservice.repositories.WorkRepository;
import ru.stretenskiy.autoservice.services.WorkService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkServiceImpl implements WorkService {

    private final WorkRepository workRepository;

    @Override
    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }

    @Override
    @Transactional
    public Long saveWork(@NotNull Work work) {
        log.info("Saving new {}", work);
        return workRepository.save(work).getId();
    }

    @Override
    @Transactional
    public void deleteWork(@NotNull Work work) {
        log.info("Delete {}", work);
        workRepository.delete(work);
    }

    @Override
    public Optional<Work> getWorkById(@NotNull Long id) {
        return workRepository.findById(id);
    }

}
