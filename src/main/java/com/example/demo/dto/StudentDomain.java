package com.example.demo.dto;

import com.example.demo.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDomain {
    private Integer id;
    private String name;
    private Date entranceDate;
    private Group group;
}
