package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
    private String id;
    private String name;
    private Double salary;
    private Integer age;
    private @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date bir;
    private Dept dept;
}
