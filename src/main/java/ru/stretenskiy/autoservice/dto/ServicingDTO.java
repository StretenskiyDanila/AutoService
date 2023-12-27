package ru.stretenskiy.autoservice.dto;

import lombok.Data;
import ru.stretenskiy.autoservice.entities.Servicing;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ServicingDTO {

    private Long id;
    private String name;
    private BigDecimal costOur;
    private BigDecimal costForeign;

    public static ServicingDTO buildServiceDTO(Servicing servicing) {
        ServicingDTO servicingDTO = new ServicingDTO();
        servicingDTO.setId(servicing.getId());
        servicingDTO.setName(servicing.getName());
        servicingDTO.setCostOur(servicing.getCostOur());
        servicingDTO.setCostForeign(servicing.getCostForeign());
        return servicingDTO;
    }

}
