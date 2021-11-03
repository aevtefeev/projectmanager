package ru.crmkrd.projectmanager.entity;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Title", length = 30)
    private String title;

    @Column(name = "Descriptoin", length = 120)
    private String descriptoin;

    @ManyToOne
    @JoinColumn(name = "Autor")
    private User autor;

    @ManyToOne
    @JoinColumn(name = "Executor")
    private User executor;

    @ManyToOne
    @JoinColumn(name = "History")
    private History history;

    @ManyToOne
    @JoinColumn(name = "Relizes")
    private Reliz relizes;

    @ManyToOne
    @JoinColumn(name = "Project")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "Status")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Reliz getRelizes() {
        return relizes;
    }

    public void setRelizes(Reliz relizes) {
        this.relizes = relizes;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public String getDescriptoin() {
        return descriptoin;
    }

    public void setDescriptoin(String descriptoin) {
        this.descriptoin = descriptoin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}