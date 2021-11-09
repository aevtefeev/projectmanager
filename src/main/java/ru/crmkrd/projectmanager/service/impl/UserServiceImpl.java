package ru.crmkrd.projectmanager.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.crmkrd.projectmanager.dto.UserDto;
import ru.crmkrd.projectmanager.entity.User;
import ru.crmkrd.projectmanager.mapper.UserMapper;
import ru.crmkrd.projectmanager.repository.UserRepository;
import ru.crmkrd.projectmanager.service.UserService;
import ru.crmkrd.projectmanager.util.ServiceUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper userMapper = null;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    //    this.userMapper = userMapper;
    }

    public UserDto save(UserDto userDto) {
        User entity = userMapper.toEntity(userDto);
        return userMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public UserDto findById(Long id) {
        return userMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<UserDto> findByCondition(UserDto userDto, Pageable pageable) {
        Page<User> entityPage = repository.findAll(pageable);
        List<User> entities = entityPage.getContent();
        return new PageImpl<>(userMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public UserDto update(UserDto userDto, Long id) {
        UserDto data = findById(id);
        User entity = userMapper.toEntity(userDto);
        ServiceUtil.copyProperties(data, entity);
        return save(userMapper.toDto(entity));
    }
}