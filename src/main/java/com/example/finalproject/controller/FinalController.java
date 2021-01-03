package com.example.finalproject.controller;

import com.example.finalproject.service.FinalService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor

public class FinalController {

    //get a 400 bad request error
    @PostMapping("/start")
    public Object getNameAge(@RequestBody String name, @RequestBody Integer age) {
        return FinalService.getNameAge(name, age);
    }

    @GetMapping("/time")
    public Object getTime() {
        return FinalService.getTime();
    }

    //get a 400 bad request error and Invalid character found in the request target [/api/v1/%7Badd%7D?v1={4}].
    @PostMapping("/{operation}{x}")
    public Object doMath(@PathVariable String operation, @RequestParam(required = true) float v1, @PathVariable float x, @RequestBody float[] nums) {
        return FinalService.doMath(operation, x, nums);
    }
//?v1=    POST /api/v1/{operation}?v1={x}
}
