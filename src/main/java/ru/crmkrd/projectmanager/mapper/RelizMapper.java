package ru.crmkrd.projectmanager.mapper;

import org.mapstruct.Mapper;
import ru.crmkrd.projectmanager.dto.RelizDto;
import ru.crmkrd.projectmanager.entity.Reliz;

@Mapper(componentModel = "spring")
public interface RelizMapper extends EntityMapper<RelizDto, Reliz> {
}