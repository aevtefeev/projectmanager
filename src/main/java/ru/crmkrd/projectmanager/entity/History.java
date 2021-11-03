package ru.crmkrd.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class History {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Description", length = 180)
    private String description;

    @Column(name = "DateTime")
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