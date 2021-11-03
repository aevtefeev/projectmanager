package ru.crmkrd.projectmanager.dto;

import ru.crmkrd.projectmanager.entity.*;

import javax.validation.constraints.Size;

//@ApiModel()
public class TaskDto extends AbstractDto<Long> {
    private Long id;
    @Size(max = 30)
    private String title;
    @Size(max = 120)
    private String descriptoin;
    private User autor;
    private User executor;
    private History history;
    private Reliz relizes;
    private Project project;
    private Status status;

    public TaskDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescriptoin(String descriptoin) {
        this.descriptoin = descriptoin;
    }

    public String getDescriptoin() {
        return this.descriptoin;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public User getAutor() {
        return this.autor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public User getExecutor() {
        return this.executor;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public History getHistory() {
        return this.history;
    }

    public void setRelizes(Reliz relizes) {
        this.relizes = relizes;
    }

    public Reliz getRelizes() {
        return this.relizes;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return this.project;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }
}