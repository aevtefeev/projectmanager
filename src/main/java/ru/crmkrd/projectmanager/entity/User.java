package ru.crmkrd.projectmanager.entity;

import javax.persistence.*;

@Table(name = "Users")
@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Name", length = 30)
    private String name;

    @Column(name = "SecondName", length = 30)
    private String secondName;

    @ManyToOne
    @JoinColumn(name = "Role")
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