package ru.crmkrd.projectmanager.dto;


import javax.validation.constraints.Size;
import java.time.LocalDate;

//@ApiModel()
public class RelizDto extends AbstractDto<Long> {
    private Long id;
    @Size(max = 50)
    private String caption;
    @Size(max = 120)
    private String description;
    private LocalDate dateStart;
    private LocalDate dateEnd;

    public RelizDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
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
}