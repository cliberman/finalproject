package com.example.finalproject.controller;

import com.example.finalproject.service.FinalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
public class FinalControllerTest {

    private FinalService finalService;

    @Mock
    private FinalService mockFinalService;

    @InjectMocks
    private FinalController mockFinalController;

    @Test
    public void start_shouldCallService_andReturnItsResult() {

        when(mockFinalService.getNameAge(anyString(), anyInt())).thenReturn(new ResponseEntity<>("User is over bar mitzvah.", HttpStatus.OK));
        //Object actualResponseEntity = finalService.getNameAge("Chana", 20);
        assertThat(mockFinalService.getNameAge("Chana", 20)).isEqualTo(new ResponseEntity<>("User is over bar mitzvah.", HttpStatus.OK));
        verify(mockFinalService).getNameAge("Chana", 20);
    }


    @Test
    public void start_returnsUnauthorized_whenCalledWithNoName() {
        ResponseEntity expectedResponseEntity = new ResponseEntity("Sorry, you must enter a name.", HttpStatus.UNAUTHORIZED);
        Object actualResponseEntity = finalService.getNameAge("", 14);
        assertThat(actualResponseEntity).isEqualTo(expectedResponseEntity);
    }

}

//tests:    1. test that exception is thrown when no name entered
//          2. test that name and age entered gives right result (2)