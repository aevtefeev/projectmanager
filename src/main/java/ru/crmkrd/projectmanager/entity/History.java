package ru.crmkrd.projectmanager.entity;

import io.swagger.v3.oas.annotations.Hidden;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Hidden
public class History {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description", length = 180)
    private String description;

    @Column(name = "date_time")
    private LocalDate dateTime;

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}