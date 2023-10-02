package ru.stretenskiy.autoservice.service;

import ru.stretenskiy.autoservice.entity.Car;
import ru.stretenskiy.autoservice.entity.Master;
import ru.stretenskiy.autoservice.entity.Servicing;
import ru.stretenskiy.autoservice.entity.Work;

import java.util.List;

public interface WorksService {

    void addWork(Work work);

    Work getWorkById(Long id);

    List<Work> getWorks();

    List<Work> getWorksByService(Servicing servicing);

    List<Work> getWorksByMaster(Master master);

    List<Work> getWorksByCar(Car car);

}
