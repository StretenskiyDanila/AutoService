package ru.stretenskiy.autoservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.stretenskiy.autoservice.entity.Car;
import ru.stretenskiy.autoservice.entity.Master;
import ru.stretenskiy.autoservice.entity.Servicing;
import ru.stretenskiy.autoservice.entity.Work;
import ru.stretenskiy.autoservice.repository.WorksRepository;
import ru.stretenskiy.autoservice.service.WorksService;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WorksServiceImpl implements WorksService {

    @Autowired
    private WorksRepository worksRepository;

    @Override
    public void addWork(Work work) {
        worksRepository.save(work);
    }

    @Override
    public Work getWorkById(Long id) {
        return worksRepository.findById(id).orElse(null);
    }

    @Override
    public List<Work> getWorks() {
        log.info("Get all works");
        return worksRepository.findAll();
    }

    @Override
    public List<Work> getWorksByService(Servicing servicing) {
        return worksRepository.findByServicingId(servicing.getId());
    }

    @Override
    public List<Work> getWorksByMaster(Master master) {
        return worksRepository.findByMasterId(master.getId());
    }

    @Override
    public List<Work> getWorksByCar(Car car) {
        return worksRepository.findByCarId(car.getId());
    }

}
