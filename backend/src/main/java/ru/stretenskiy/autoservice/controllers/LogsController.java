package ru.stretenskiy.autoservice.controllers;

import com.google.common.io.Files;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogsController {

    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> getLogs() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat();
        File file = new File("var\\lib\\postgres\\data\\pg_log\\postgresql-" + formatter.format(date) + ".log");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType((new MediaType("application", "force-download")));
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=logs.log");
        try {
            ByteArrayResource byteArrayResource = new ByteArrayResource(Files.toByteArray(file));
            return new ResponseEntity<>(byteArrayResource, headers, HttpStatus.CREATED);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

}
