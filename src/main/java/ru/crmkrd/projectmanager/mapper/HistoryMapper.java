package ru.crmkrd.projectmanager.mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.crmkrd.projectmanager.dto.HistoryDto;
import ru.crmkrd.projectmanager.entity.History;

@Mapper(componentModel = "spring")
public interface HistoryMapper extends EntityMapper<HistoryDto, History> {
}