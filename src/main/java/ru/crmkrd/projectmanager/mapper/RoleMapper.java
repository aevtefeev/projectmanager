package ru.crmkrd.projectmanager.mapper;

import org.mapstruct.Mapper;
import ru.crmkrd.projectmanager.dto.RoleDto;
import ru.crmkrd.projectmanager.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDto, Role> {
}