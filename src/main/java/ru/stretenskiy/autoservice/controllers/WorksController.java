package ru.stretenskiy.autoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stretenskiy.autoservice.entity.Work;
import ru.stretenskiy.autoservice.service.WorksService;

import java.util.List;

@RestController
@RequestMapping("/works")
public class WorksController {

    @Autowired
    private WorksService worksService;

    @GetMapping("/id")
    public ResponseEntity<Work> getWorkId() {

        return ResponseEntity.ok(worksService.getWorkById(1L));
    }

}
