package com.example.finalproject.controller;

import com.example.finalproject.model.UserInfo;
import com.example.finalproject.service.FinalService;
import org.apache.catalina.User;
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
import static org.mockito.ArgumentMatchers.*;
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
        UserInfo user = new UserInfo("Chana", 20);
        when(mockFinalService.getNameAge(any(UserInfo.class))).thenReturn(new ResponseEntity<>("User is over bar mitzvah.", HttpStatus.OK));
        Object actualResponseEntity = finalService.getNameAge(user);
        assertThat(mockFinalService.getNameAge(user)).isEqualTo(new ResponseEntity<>("User is over bar mitzvah.", HttpStatus.OK));
        verify(mockFinalService).getNameAge(user);
    }


    @Test
    public void start_returnsUnauthorized_whenCalledWithNoName() {
        ResponseEntity expectedResponseEntity = new ResponseEntity("Sorry, you must enter a name.", HttpStatus.UNAUTHORIZED);
        Object actualResponseEntity = finalService.getNameAge(new UserInfo("", 14));
        assertThat(actualResponseEntity).isEqualTo(expectedResponseEntity);
    }

}

//tests:    1. test that exception is thrown when no name entered
//          2. test that name and age entered gives right result (2)