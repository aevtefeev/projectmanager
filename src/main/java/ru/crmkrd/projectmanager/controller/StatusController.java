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
import ru.crmkrd.projectmanager.dto.StatusDto;
import ru.crmkrd.projectmanager.entity.Status;
import ru.crmkrd.projectmanager.mapper.StatusMapper;
import ru.crmkrd.projectmanager.service.StatusService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/status")
@RestController

@Tag(name="Status", description="Rest for Status")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated StatusDto statusDto) {
        statusService.save(statusDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> findById(@PathVariable("id") Long id) {
        StatusDto status = statusService.findById(id);
        return ResponseEntity.ok(status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        statusService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<StatusDto>> pageQuery(StatusDto statusDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<StatusDto> statusPage = statusService.findByCondition(statusDto, pageable);
        return ResponseEntity.ok(statusPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated StatusDto statusDto, @PathVariable("id") Long id) {
        statusService.update(statusDto, id);
        return ResponseEntity.ok().build();
    }
}