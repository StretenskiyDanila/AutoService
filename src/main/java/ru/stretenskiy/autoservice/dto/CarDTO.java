package ru.stretenskiy.autoservice.dto;

import lombok.Data;
import ru.stretenskiy.autoservice.entities.Car;

@Data
public class CarDTO {

    private Long id;
    private String number;
    private String color;
    private String mark;
    private Integer isForeign;

    public static CarDTO buildCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setNumber(car.getNumber());
        carDTO.setColor(car.getColor());
        carDTO.setMark(car.getMark());
        carDTO.setIsForeign(car.getIsForeign());
        return carDTO;
    }

}
