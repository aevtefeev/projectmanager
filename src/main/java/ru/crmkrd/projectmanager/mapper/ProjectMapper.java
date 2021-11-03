package ru.crmkrd.projectmanager.mapper;

import org.mapstruct.Mapper;
import ru.crmkrd.projectmanager.dto.ProjectDto;
import ru.crmkrd.projectmanager.entity.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends EntityMapper<ProjectDto, Project> {
}