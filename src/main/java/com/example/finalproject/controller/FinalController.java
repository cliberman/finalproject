package com.example.finalproject.controller;

import com.example.finalproject.configuration.MathConfiguration;
import com.example.finalproject.model.NumArray;
import com.example.finalproject.model.UserInfo;
import com.example.finalproject.service.FinalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
//@RequiredArgsConstructor

public class FinalController {

    private final FinalService finalService;
    private final MathConfiguration mathConfiguration;

    public FinalController(FinalService finalService, MathConfiguration mathConfiguration) {
        this.finalService = finalService;
        this.mathConfiguration = mathConfiguration;
    }

    @PostMapping("/start")
    public ResponseEntity getNameAge(@RequestBody UserInfo userInfo) {
        return finalService.getNameAge(userInfo);
    }

    @GetMapping("/time")
    public Object getTime() {
        return finalService.getTime();
    }

    @PostMapping("/{operation}")
    public Object doMath(@PathVariable String operation, @RequestParam(name="v1") float x, @RequestBody NumArray numArray) {
        if (mathConfiguration.isMathallowed()) {
            return finalService.doMath(operation, x, numArray);
        } else {
            return new ResponseEntity<>("Sorry, no math allowed here.", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
