package ru.crmkrd.projectmanager.entity;

import io.swagger.v3.oas.annotations.Hidden;

import javax.persistence.*;

@Table(name = "Users")
@Entity
@Hidden
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "second_name", length = 30)
    private String secondName;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}