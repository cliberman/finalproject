package com.example.finalproject.controller;

import com.example.finalproject.configuration.MathConfiguration;
import com.example.finalproject.service.FinalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
//@RequiredArgsConstructor

public class FinalController {

    private final FinalService finalService;

    public FinalController(FinalService finalService) {
        this.finalService = finalService;
    }

    //get a 400 bad request error
    @PostMapping("/start")
    public ResponseEntity getNameAge(@RequestBody String name, @RequestBody Integer age) {
        return finalService.getNameAge(name, age);
        //return FinalService.getNameAge(name, age);
    }

    @GetMapping("/time")
    public Object getTime() {
        return FinalService.getTime();
    }

    //get a 400 bad request error and Invalid character found in the request target [/api/v1/%7Badd%7D?v1={4}].
    @PostMapping("/{operation}")
    public Object doMath(@PathVariable String operation, @RequestParam(required = true) float v1, @RequestBody float[] nums) {
        return FinalService.doMath(operation, v1, nums);
    }
//?v1=    POST /api/v1/{operation}?v1={x}
}
