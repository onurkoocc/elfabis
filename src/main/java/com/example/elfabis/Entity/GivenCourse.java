package com.example.elfabis.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "given_course")
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class GivenCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name="lecturer_id")
    private Academician lecturer;
    private int year;
    private int semester;
    private int courseGroup;
}
