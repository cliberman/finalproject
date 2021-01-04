package com.example.finalproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NumArray {
    private float[] nums;

    public NumArray(float[] nums) {
        this.nums = nums;
    }
}
