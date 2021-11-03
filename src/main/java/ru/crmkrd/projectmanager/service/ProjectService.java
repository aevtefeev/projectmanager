package ru.crmkrd.projectmanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.crmkrd.projectmanager.dto.ProjectDto;
import ru.crmkrd.projectmanager.entity.Project;
import ru.crmkrd.projectmanager.mapper.ProjectMapper;
import ru.crmkrd.projectmanager.repository.ProjectRepository;
import ru.crmkrd.projectmanager.util.ServiceUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {
    private final ProjectRepository repository;
    private final ProjectMapper projectMapper = null;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
      //  this.projectMapper = projectMapper;
    }

    public ProjectDto save(ProjectDto projectDto) {
        Project entity = projectMapper.toEntity(projectDto);
        return projectMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ProjectDto findById(Long id) {
        return projectMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<ProjectDto> findByCondition(ProjectDto projectDto, Pageable pageable) {
        Page<Project> entityPage = repository.findAll(pageable);
        List<Project> entities = entityPage.getContent();
        return new PageImpl<>(projectMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public ProjectDto update(ProjectDto projectDto, Long id) {
        ProjectDto data = findById(id);
        Project entity = projectMapper.toEntity(projectDto);
        ServiceUtil.copyProperties(data, entity);
        return save(projectMapper.toDto(entity));
    }
}