
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.lang.String.*;

@SpringBootApplication
@RestController
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Lina") String name) {
        return String.format("Hello %s!", name);
    }

    // Wenn der Text "check mich" im Body (plain text) gesendet wird, bekommt man eine 200 zurück, sonst 400!

    @PostMapping("/check")
    public ResponseEntity<String> checker(@RequestBody String wordchecker) {
        if (wordchecker.equals("check mich")) {
            // HttpStatus.OK ist 200 also alles i.O.
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        // HttpStatus.BadRequest ist 400 also fehlerhafte Eingabe.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

            