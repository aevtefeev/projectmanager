package ru.crmkrd.projectmanager.mapper;

import org.mapstruct.Mapper;
import ru.crmkrd.projectmanager.dto.history.HistoryRequestDto;
import ru.crmkrd.projectmanager.entity.History;

@Mapper(componentModel = "spring")
public interface HistoryMapper extends EntityMapper<HistoryRequestDto, History> {
}