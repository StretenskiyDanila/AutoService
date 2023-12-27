package ru.stretenskiy.autoservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stretenskiy.autoservice.dto.ServicingDTO;
import ru.stretenskiy.autoservice.entities.Servicing;
import ru.stretenskiy.autoservice.services.ServicingService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServicingController {

    private final ServicingService servicingService;

    @GetMapping()
    public ResponseEntity<List<ServicingDTO>> getAllServicing() {
        List<Servicing> servicings = servicingService.getAllServices();
        return ResponseEntity.ok(servicings.stream().map(ServicingDTO::buildServiceDTO).collect(Collectors.toList()));
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addServicing(@RequestBody ServicingDTO servicingDTO) {
        Servicing servicing = new Servicing();
        servicing.setId(servicingDTO.getId());
        servicing.setName(servicingDTO.getName());
        servicing.setCostOur(servicingDTO.getCostOur());
        servicing.setCostForeign(servicingDTO.getCostForeign());
        try {
            return ResponseEntity.ok(servicingService.saveServicing(servicing));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<Long> updateServicing(@RequestBody ServicingDTO servicingDTO) {
        Optional<Servicing> servicingOpt = servicingService.getServicingById(servicingDTO.getId());
        if (servicingOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Servicing servicing = servicingOpt.get();
        servicing.setName(servicingDTO.getName());
        servicing.setCostOur(servicingDTO.getCostOur());
        servicing.setCostForeign(servicingDTO.getCostForeign());
        try {
            return ResponseEntity.ok(servicingService.saveServicing(servicing));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteServicing(@RequestParam(name = "id") Long id) {
        Optional<Servicing> servicingOpt = servicingService.getServicingById(id);
        if (servicingOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
        try {
            servicingService.deleteServicing(servicingOpt.get());
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

}
