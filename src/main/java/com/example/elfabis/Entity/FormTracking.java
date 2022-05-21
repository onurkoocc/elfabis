package com.example.elfabis.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "form_tracking")
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class FormTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany(targetEntity = Academician.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "commission",
            joinColumns = {@JoinColumn(name = "formtracking_id")},
            inverseJoinColumns = {@JoinColumn(name = "academician_id")})
    private Set<Academician> commission = new HashSet<>();
    private boolean area1;
    private boolean area2;
    private boolean area3;
    private boolean area4;
    private boolean area5;
    private boolean area6;
    private boolean area7;
    private boolean area8;
    private boolean area9;
    private boolean area10;
    private boolean area11;
    private boolean area12;
    private boolean area13;
    private boolean form2;
    private boolean form3;
    private boolean pc;


}
