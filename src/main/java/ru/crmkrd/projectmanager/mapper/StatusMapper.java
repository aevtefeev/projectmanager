package ru.crmkrd.projectmanager.mapper;

import org.mapstruct.Mapper;
import ru.crmkrd.projectmanager.dto.StatusDto;
import ru.crmkrd.projectmanager.entity.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper extends EntityMapper<StatusDto, Status> {
}