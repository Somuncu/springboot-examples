package com.example.exceptionhandler.entity;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Bread {

    @NotNull(message = "{bread.size}")
    private Integer size;
    @Min(100)
    private Integer gram;
    @Pattern(regexp = "^[ABC]$", message = "{bread.type}")
    private String type;
    @Max(3)
    private Integer amount;

}

