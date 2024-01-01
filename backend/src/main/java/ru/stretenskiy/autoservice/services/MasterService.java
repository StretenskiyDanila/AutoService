package ru.stretenskiy.autoservice.services;

import org.springframework.core.io.ByteArrayResource;
import ru.stretenskiy.autoservice.entities.Master;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface MasterService {

    List<Master> getAllMasters();

    List<Long> getBestMasters(Date withDate, Date beforeDate);

    Long saveMaster(Master master);

    void deleteMaster(Master master);

    Optional<Master> getMasterById(Long id);

    ByteArrayResource generateReport();

}
