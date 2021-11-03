package ru.crmkrd.projectmanager.mapper;

import org.mapstruct.Mapper;
import ru.crmkrd.projectmanager.dto.TaskDto;
import ru.crmkrd.projectmanager.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper extends EntityMapper<TaskDto, Task> {
}