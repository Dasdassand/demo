package com.example.moodle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetGroupResponseBody {
    private Integer id;
    private String number;
    private Integer countStudent;
}
