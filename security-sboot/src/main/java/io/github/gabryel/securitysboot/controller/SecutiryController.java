package io.github.gabryel.securitysboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecutiryController {

    @GetMapping("/public")
    public ResponseEntity<Object> publicRoute() {
        return ResponseEntity.ok().body("public Route ok!");
    }


    @GetMapping("/private")
    public ResponseEntity<Object> privateRoute(Authentication authentication) {
        return ResponseEntity.ok().body("private Route ok! usuario: " + authentication.getName());
    }

    @GetMapping("/admin")
    public ResponseEntity<Object> adminRoute() {
        return ResponseEntity.ok().body("admin Route ok!");
    }


}
