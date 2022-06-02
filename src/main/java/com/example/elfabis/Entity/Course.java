package com.example.elfabis.Entity;

import com.example.elfabis.Pojo.Plan;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String type;
    private String abd;
    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private Academician coordinator;
    private String bolognaLink;
    private String category;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;
    private boolean equivalent;
    @ManyToOne
    @JoinColumn(name = "equivalent_course_id")
    private EquivalentCourse equivalentCourse;
}
