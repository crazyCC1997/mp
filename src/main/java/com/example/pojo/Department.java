package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

    private Integer id;

    private String dept_name;

    public Department(Integer id) {
        this.id = id;
    }
}
