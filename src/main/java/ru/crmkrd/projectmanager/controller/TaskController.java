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
import ru.crmkrd.projectmanager.dto.TaskDto;
import ru.crmkrd.projectmanager.entity.Task;
import ru.crmkrd.projectmanager.mapper.TaskMapper;
import ru.crmkrd.projectmanager.service.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/task")
@RestController

@Tag(name="Task", description="Rest for Task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated TaskDto taskDto) {
        taskService.save(taskDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findById(@PathVariable("id") Long id) {
        TaskDto task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<TaskDto>> pageQuery(TaskDto taskDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<TaskDto> taskPage = taskService.findByCondition(taskDto, pageable);
        return ResponseEntity.ok(taskPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated TaskDto taskDto, @PathVariable("id") Long id) {
        taskService.update(taskDto, id);
        return ResponseEntity.ok().build();
    }
}