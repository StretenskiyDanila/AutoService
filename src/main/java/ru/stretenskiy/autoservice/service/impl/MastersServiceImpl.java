package ru.stretenskiy.autoservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.stretenskiy.autoservice.entity.Master;
import ru.stretenskiy.autoservice.repository.MasterRepository;
import ru.stretenskiy.autoservice.service.MastersService;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MastersServiceImpl implements MastersService {

    @Autowired
    private MasterRepository masterRepository;

    @Override
    public void addMasters(Master master) {
        masterRepository.save(master);
    }

    @Override
    public Master getMasterById(Long id) {
        return masterRepository.findById(id).orElse(null);
    }

    @Override
    public Master getMasterByName(String masterName) {
        return masterRepository.findByName(masterName).orElse(null);
    }

    @Override
    public List<Master> getMasters() {
        return masterRepository.findAll();
    }
}
