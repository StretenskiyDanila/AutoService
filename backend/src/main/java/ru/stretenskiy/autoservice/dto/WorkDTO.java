package ru.stretenskiy.autoservice.dto;

import lombok.Data;
import ru.stretenskiy.autoservice.entities.Work;

import java.sql.Date;

@Data
public class WorkDTO {

    private Long id;
    private Date dateWork;
    private Long master;
    private Long car;
    private Long servicing;

    public static WorkDTO buildWorkDTO(Work work) {
        WorkDTO workDTO = new WorkDTO();
        workDTO.setId(work.getId());
        workDTO.setDateWork(work.getDateWork());
        workDTO.setMaster(work.getMaster().getId());
        workDTO.setCar(work.getCar().getId());
        workDTO.setServicing(work.getServicing().getId());
        return workDTO;
    }

}
