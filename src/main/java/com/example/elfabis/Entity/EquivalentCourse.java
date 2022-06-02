package com.example.elfabis.Entity;

import javax.persistence.*;

@Entity
@Table(name = "equivalent_course")
public class EquivalentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
