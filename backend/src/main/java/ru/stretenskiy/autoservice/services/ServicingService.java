package ru.stretenskiy.autoservice.services;

import org.springframework.core.io.ByteArrayResource;
import ru.stretenskiy.autoservice.entities.Servicing;
import ru.stretenskiy.autoservice.utils.CostServices;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ServicingService {

    List<Servicing> getAllServices();

    Optional<CostServices> getSumCost(Date withDate, Date beforeDate);

    Long saveServicing(Servicing servicing);

    void deleteServicing(Servicing service);

    Optional<Servicing> getServicingById(Long id);

    ByteArrayResource generateReport();

}
