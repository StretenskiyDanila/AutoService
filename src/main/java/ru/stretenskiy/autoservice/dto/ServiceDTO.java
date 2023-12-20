package ru.stretenskiy.autoservice.dto;

import lombok.Data;
import ru.stretenskiy.autoservice.entities.Service;

import java.math.BigInteger;

@Data
public class ServiceDTO {

    private Long id;
    private String name;
    private BigInteger costOur;
    private BigInteger costForeign;

    public static ServiceDTO buildServiceDTO(Service service) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(service.getId());
        serviceDTO.setName(service.getName());
        serviceDTO.setCostOur(service.getCostOur());
        serviceDTO.setCostForeign(service.getCostForeign());
        return serviceDTO;
    }

}
