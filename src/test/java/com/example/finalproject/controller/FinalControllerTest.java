package com.example.finalproject.controller;

import com.example.finalproject.service.FinalService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class FinalControllerTest {

    @InjectMocks
    private FinalService finalService;

    @Test
    public void start_returnsUnauthorized_whenCalledWithNoName() {
        ResponseEntity expectedResponseEntity = new ResponseEntity("Sorry, you must enter a name.", HttpStatus.UNAUTHORIZED);
        Object actualResponseEntity = finalService.getNameAge("", 14);
        assertThat(actualResponseEntity).isEqualTo(expectedResponseEntity);
    }

}