package ru.stretenskiy.autoservice.services;

import ru.stretenskiy.autoservice.entities.Master;

import java.util.List;
import java.util.Optional;

public interface MasterService {

    List<Master> getAllMasters();

    Long saveMaster(Master master);

    void deleteMaster(Master master);

    Optional<Master> getMasterById(Long id);

}
