package ru.stretenskiy.autoservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stretenskiy.autoservice.dto.MasterDTO;
import ru.stretenskiy.autoservice.entities.Master;
import ru.stretenskiy.autoservice.services.MasterService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/masters")
@RequiredArgsConstructor
public class MasterController {

    private final MasterService masterService;

    @GetMapping()
    public ResponseEntity<List<MasterDTO>> getAllMasters() {
        List<Master> masterList = masterService.getAllMasters();
        return ResponseEntity.ok(masterList.stream().map(MasterDTO::buildMaster).collect(Collectors.toList()));
    }

    @GetMapping("/5_best_masters")
    public ResponseEntity<List<Long>> getBestMasters(@RequestParam(name = "begin") String withDate,
                                                     @RequestParam(name = "end") String beforeDate) {
        Date withDateSql = Date.valueOf(withDate);
        Date beforeDateSql = Date.valueOf(beforeDate);
        if (withDateSql.after(beforeDateSql)) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(masterService.getBestMasters(withDateSql, beforeDateSql));
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addMaster(@RequestBody MasterDTO masterDTO) {
        Master master = new Master();

        master.setId(masterDTO.getId());
        master.setName(masterDTO.getName());

        try {
            return ResponseEntity.ok(masterService.saveMaster(master));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<Long> updateMaster(@RequestBody MasterDTO masterDTO) {
        Optional<Master> masterOpt = masterService.getMasterById(masterDTO.getId());
        if (masterOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Master master = masterOpt.get();
        master.setName(masterDTO.getName());
        try {
            return ResponseEntity.ok(masterService.saveMaster(master));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteMaster(@RequestParam(name = "id") Long id) {
        Optional<Master> masterOpt = masterService.getMasterById(id);
        if (masterOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
        try {
            masterService.deleteMaster(masterOpt.get());
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(false);
        }
    }

}
