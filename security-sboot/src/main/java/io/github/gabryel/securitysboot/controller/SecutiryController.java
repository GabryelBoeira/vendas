package io.github.gabryel.securitysboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecutiryController {

    @GetMapping("/public")
    public ResponseEntity<Object> publicRoute() {
        return ResponseEntity.ok().body("public Route ok!");
    }


    @GetMapping("/private")
    public ResponseEntity<Object> privateRoute() {
        return ResponseEntity.ok().body("private Route ok!");
    }


}
