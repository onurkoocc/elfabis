package com.example.elfabis.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "equivalent_course")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class EquivalentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
