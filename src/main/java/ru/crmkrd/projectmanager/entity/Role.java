package ru.crmkrd.projectmanager.entity;

import io.swagger.v3.oas.annotations.Hidden;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Hidden
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role", length = 10)
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}