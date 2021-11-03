package ru.crmkrd.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Reliz {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Caption", length = 50)
    private String caption;

    @Column(name = "Description", length = 120)
    private String description;

    @Column(name = "DateStart")
    private LocalDate dateStart;

    @Column(name = "DateEnd")
    private LocalDate dateEnd;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}