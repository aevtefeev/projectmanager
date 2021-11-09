package ru.crmkrd.projectmanager.dto.history;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.constraints.Size;
import java.time.LocalDate;


@Tag(name= "HistoryDTO", description = "Возвращаемые данные")
public class HistoryRequestDto {
    private Long id;
    @Size(max = 180)
    private String description;
    private LocalDate dateTime;

    public HistoryRequestDto(String description, LocalDate dateTime) {
        this.description = description;
        this.dateTime = dateTime;
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