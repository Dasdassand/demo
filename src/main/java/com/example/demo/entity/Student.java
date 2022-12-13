package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    public Student(String name, Date entranceDate, Group group) {
        this.name = name;
        this.entranceDate = entranceDate;
        this.group = group;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String name;

    @Column(name = "entrance_date")
    private Date entranceDate;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


}
