package com.example.elfabis.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "academician",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Getter
@Setter
public class Academician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(max = 20)
    private String username = "";
    @NotBlank
    @Size(max = 120)
    private String password = "";
    @NotBlank
    @Size(max = 50)
    @Email
    private String email = "";
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private String name;
    private String title;
    private String abd;
    private String abbr;
    @JsonIgnore
    @ManyToMany(mappedBy = "commission")
    private Set<FormTracking> formTrackings;

    public Academician() {
    }

    public Academician(String username, String email, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Academician(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
