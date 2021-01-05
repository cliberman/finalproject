package com.example.finalproject.service;

import com.example.finalproject.configuration.MathConfiguration;
import com.example.finalproject.model.NumArray;
import com.example.finalproject.model.UserInfo;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.zip.DataFormatException;

@Service
@Data
@RequiredArgsConstructor
public class FinalService {

    public ResponseEntity getNameAge(UserInfo userInfo) {
        String name = userInfo.getName();
        Integer age = userInfo.getAge();
        System.out.println("name: " + name + "age: " + age);
        if (name.isEmpty()) {
            return new ResponseEntity<>("Sorry, you must enter a name.", HttpStatus.UNAUTHORIZED);
        } else {
            if (age >= 13) {
                return new ResponseEntity<>("User is over bar mitzvah.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User is under bar mitzvah.", HttpStatus.OK);
            }
        }
    }

    public Object getTime() {
        Date date = new Date();
        return date;
    }

    public Object doMath(String operation, float x, NumArray numArray) {
        float[] nums = numArray.getNums();
        ResponseEntity responseEntity;
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
}
