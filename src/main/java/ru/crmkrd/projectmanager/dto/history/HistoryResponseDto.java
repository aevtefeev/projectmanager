package ru.crmkrd.projectmanager.dto.history;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;

@Tag(name = "ResponseDTO", description = "Получаемые данные")
public class HistoryResponseDto {

    public HistoryResponseDto(String description, LocalDate dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    private String description;
    private LocalDate dateTime;


}
