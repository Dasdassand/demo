package com.example.moodle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentResponseBody {
    private Integer id;
    private String name;
    private Date entranceDate;
}
