package ru.stretenskiy.autoservice.service;

import ru.stretenskiy.autoservice.entity.Servicing;

import java.util.List;

public interface ServicingService {

    void addServices(Servicing servicing);

    Servicing getServiceById(Long id);

    Servicing getServiceByName(String servicingName);

    List<Servicing> getServicing();

}
