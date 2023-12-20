package ru.stretenskiy.autoservice.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stretenskiy.autoservice.entities.Master;
import ru.stretenskiy.autoservice.repositories.MasterRepository;
import ru.stretenskiy.autoservice.services.MasterService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MasterServiceImpl implements MasterService {

    private final MasterRepository masterRepository;

    @Override
    public List<Master> getAllMasters() {
        return masterRepository.findAll();
    }

    @Override
    @Transactional
    public Long saveMaster(Master master) {
        log.info("Saving new {}", master);
        return masterRepository.save(master).getId();
    }

    @Override
    @Transactional
    public void deleteMaster(Master master) {
        log.info("Delete {}", master);
        masterRepository.delete(master);
    }

    @Override
    public Optional<Master> getMasterById(Long id) {
        return masterRepository.findById(id);
    }

}
