package ru.stretenskiy.autoservice.Controllers;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ControllerMy {

    @GetMapping("/")
    public ResponseEntity<String> pr() {
        return ResponseEntity.ok("name");
    }

}
