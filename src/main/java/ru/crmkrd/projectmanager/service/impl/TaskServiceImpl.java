package ru.crmkrd.projectmanager.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.crmkrd.projectmanager.dto.TaskDto;
import ru.crmkrd.projectmanager.entity.Task;
import ru.crmkrd.projectmanager.mapper.TaskMapper;
import ru.crmkrd.projectmanager.repository.TaskRepository;
import ru.crmkrd.projectmanager.service.TaskService;
import ru.crmkrd.projectmanager.util.ServiceUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final TaskMapper taskMapper = null;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
     //   this.taskMapper = taskMapper;
    }

    public TaskDto save(TaskDto taskDto) {
        Task entity = taskMapper.toEntity(taskDto);
        return taskMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public TaskDto findById(Long id) {
        return taskMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<TaskDto> findByCondition(TaskDto taskDto, Pageable pageable) {
        Page<Task> entityPage = repository.findAll(pageable);
        List<Task> entities = entityPage.getContent();
        return new PageImpl<>(taskMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public TaskDto update(TaskDto taskDto, Long id) {
        TaskDto data = findById(id);
        Task entity = taskMapper.toEntity(taskDto);
        ServiceUtil.copyProperties(data, entity);
        return save(taskMapper.toDto(entity));
    }
}