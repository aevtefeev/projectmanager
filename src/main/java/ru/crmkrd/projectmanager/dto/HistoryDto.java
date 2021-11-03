package ru.crmkrd.projectmanager.dto;



import javax.validation.constraints.Size;
import java.time.LocalDate;

//@ApiModel()
public class HistoryDto extends AbstractDto<Long> {
    private Long id;
    @Size(max = 180)
    private String description;
    private LocalDate dateTime;

    public HistoryDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDateTime(java.time.LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public java.time.LocalDate getDateTime() {
        return this.dateTime;
    }
}