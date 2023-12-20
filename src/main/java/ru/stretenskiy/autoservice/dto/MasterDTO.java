package ru.stretenskiy.autoservice.dto;

import lombok.Data;
import ru.stretenskiy.autoservice.entities.Master;

@Data
public class MasterDTO {

    private Long id;
    private String name;

    public static MasterDTO buildMaster(Master master) {
        MasterDTO masterDTO = new MasterDTO();
        masterDTO.setId(master.getId());
        masterDTO.setName(master.getName());
        return masterDTO;
    }

}
