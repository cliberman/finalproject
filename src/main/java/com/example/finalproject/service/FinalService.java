package com.example.finalproject.service;

import com.example.finalproject.configuration.MathConfiguration;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.zip.DataFormatException;

@Builder
@Service
@Data
//@RequiredArgsConstructor
public class FinalService {

    public static Object getNameAge(String name, Integer age) {

        if (name.isEmpty()) {
            //System.out.println("name is empty!");
            return new ResponseEntity<>("Sorry, you must enter a name.", HttpStatus.UNAUTHORIZED);
        } else {
            if (age >= 13) {
                return new ResponseEntity<>("User is over bar mitzvah.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User is under bar mitzvah.", HttpStatus.OK);
            }
        }
    }

    public static Object getTime() {
        Date date = new Date();
        return date;
    }

    public static Object doMath(String operation, float x, float[] nums) {
        ResponseEntity responseEntity;
        MathConfiguration mathConfiguration = new MathConfiguration();
        if(mathConfiguration.isMathallowed()==true) {
            if (operation.equals("add")) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] += x;
                }
            } else if (operation.equals("subtract")) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = nums[i] - x;
                }
            } else if (operation.equals("multiply")) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = nums[i] * x;
                }
            } else if (operation.equals("divide")) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = nums[i] / x;
                }
            }
            return new ResponseEntity<>(nums, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Sorry, no math allowed here.", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
