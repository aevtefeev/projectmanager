package ru.crmkrd.projectmanager.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Project {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ProjectName", length = 30)
    private String projectName;

    @Column(name = "Description", length = 120)
    private String description;

    @ManyToOne
    @JoinColumn(name = "Autor")
    private User autor;

    @Column(name = "DateStart")
    private LocalDate dateStart;

    @Column(name = "DateEnd")
    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(name = "Status")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}