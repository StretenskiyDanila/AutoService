package ru.stretenskiy.autoservice.service;

import ru.stretenskiy.autoservice.entity.Car;
import ru.stretenskiy.autoservice.entity.Master;

import java.util.List;

public interface MastersService {

    void addMasters(Master master);

    Master getMasterById(Long id);

    Master getMasterByName(String masterName);

    List<Master> getMasters();

}
