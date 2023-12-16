package ru.stretenskiy.autoservice.entities;

import org.springframework.stereotype.Component;

//Автоматическая конфигурация. Например, если сами создали
//класс и можем его легко модифицировать
@Component
public class Cars {

    private Long id;
    private String number;
    private String color;
    private String mark;
    private Integer isForeign;

}
