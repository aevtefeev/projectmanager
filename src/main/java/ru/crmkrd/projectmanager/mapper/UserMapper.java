package ru.crmkrd.projectmanager.mapper;

import org.mapstruct.Mapper;
import ru.crmkrd.projectmanager.dto.UserDto;
import ru.crmkrd.projectmanager.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {
}