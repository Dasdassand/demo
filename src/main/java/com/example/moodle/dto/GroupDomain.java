package com.example.moodle.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GroupDomain {
    private Integer id;
    private String number;
    private Date creationDate;
    private List<StudentDomain> studentDomainList;
}
