package ru.crmkrd.projectmanager.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.crmkrd.projectmanager.dto.ProjectDto;
import ru.crmkrd.projectmanager.entity.Project;
import ru.crmkrd.projectmanager.mapper.ProjectMapper;
import ru.crmkrd.projectmanager.service.ProjectService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/project")
@RestController
@Tag(name="Project", description="Rest for Project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ProjectDto projectDto) {
        projectService.save(projectDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> findById(@PathVariable("id") Long id) {
        ProjectDto project = projectService.findById(id);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        projectService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<ProjectDto>> pageQuery(ProjectDto projectDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ProjectDto> projectPage = projectService.findByCondition(projectDto, pageable);
        return ResponseEntity.ok(projectPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated ProjectDto projectDto, @PathVariable("id") Long id) {
        projectService.update(projectDto, id);
        return ResponseEntity.ok().build();
    }
}