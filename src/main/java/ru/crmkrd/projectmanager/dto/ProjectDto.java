package ru.crmkrd.projectmanager.dto;


import ru.crmkrd.projectmanager.entity.Status;
import ru.crmkrd.projectmanager.entity.User;

import javax.validation.constraints.Size;
import java.time.LocalDate;

//@ApiModel()
public class ProjectDto extends AbstractDto<Long> {
    private Long id;
    @Size(max = 30)
    private String projectName;
    @Size(max = 120)
    private String description;
    private User autor;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Status status;

    public ProjectDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public User getAutor() {
        return this.autor;
    }

    public void setDateStart(java.time.LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public java.time.LocalDate getDateStart() {
        return this.dateStart;
    }

    public void setDateEnd(java.time.LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public java.time.LocalDate getDateEnd() {
        return this.dateEnd;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }
}