package ru.stretenskiy.autoservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stretenskiy.autoservice.dto.WorkDTO;
import ru.stretenskiy.autoservice.entities.Car;
import ru.stretenskiy.autoservice.entities.Master;
import ru.stretenskiy.autoservice.entities.Servicing;
import ru.stretenskiy.autoservice.entities.Work;
import ru.stretenskiy.autoservice.services.CarService;
import ru.stretenskiy.autoservice.services.MasterService;
import ru.stretenskiy.autoservice.services.ServicingService;
import ru.stretenskiy.autoservice.services.WorkService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/works")
@RequiredArgsConstructor
public class WorkController {

    private final WorkService workService;
    private final CarService carService;
    private final ServicingService servicingService;
    private final MasterService masterService;

    @GetMapping()
    public ResponseEntity<List<WorkDTO>> getAllWorks() {
        List<Work> works = workService.getAllWorks();
        return ResponseEntity.ok(works.stream().map(WorkDTO::buildWorkDTO).collect(Collectors.toList()));
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addWork(@RequestBody WorkDTO workDTO) {
        Work work = new Work();
        Optional<Car> carOpt = carService.getCarById(workDTO.getCar());
        Optional<Master> masterOpt = masterService.getMasterById(workDTO.getMaster());
        Optional<Servicing> servicingOpt = servicingService.getServicingById(workDTO.getServicing());
        Date workDate = workDTO.getDateWork();
        if (carOpt.isEmpty() || masterOpt.isEmpty() || servicingOpt.isEmpty() || workDate.after(Date.valueOf(LocalDate.now()))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        work.setId(workDTO.getId());
        work.setDateWork(workDate);
        work.setCar(carOpt.get());
        work.setMaster(masterOpt.get());
        work.setServicing(servicingOpt.get());
        try {
            return ResponseEntity.ok(workService.saveWork(work));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<Long> updateWork(@RequestBody WorkDTO workDTO) {
        Optional<Work> workOpt = workService.getWorkById(workDTO.getId());
        Optional<Car> carOpt = carService.getCarById(workDTO.getCar());
        Optional<Master> masterOpt = masterService.getMasterById(workDTO.getMaster());
        Optional<Servicing> servicingOpt = servicingService.getServicingById(workDTO.getServicing());
        Date workDate = workDTO.getDateWork();
        if (workOpt.isEmpty() || carOpt.isEmpty() || masterOpt.isEmpty() || servicingOpt.isEmpty() || workDate.after(Date.valueOf(LocalDate.now()))) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Work work = workOpt.get();
        work.setDateWork(workDate);
        work.setCar(carOpt.get());
        work.setMaster(masterOpt.get());
        work.setServicing(servicingOpt.get());
        try {
            return ResponseEntity.ok(workService.saveWork(work));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteWork(@RequestParam Long id) {
        Optional<Work> workOpt = workService.getWorkById(id);
        if (workOpt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
        try {
            workService.deleteWork(workOpt.get());
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

}
