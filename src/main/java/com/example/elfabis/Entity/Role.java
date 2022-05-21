package com.example.elfabis.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    GrantedAuthority grantedAuthority;

    public Role() {
    }

    public void setRole(Role role) {
        this.name = role.getName();
        this.id = role.getId();
    }
}