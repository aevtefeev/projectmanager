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
import ru.crmkrd.projectmanager.dto.RoleDto;
import ru.crmkrd.projectmanager.entity.Role;
import ru.crmkrd.projectmanager.mapper.RoleMapper;
import ru.crmkrd.projectmanager.service.RoleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/role")
@RestController

@Tag(name="Role", description="Rest for Role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated RoleDto roleDto) {
        roleService.save(roleDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable("id") Long id) {
        RoleDto role = roleService.findById(id);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        roleService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<RoleDto>> pageQuery(RoleDto roleDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<RoleDto> rolePage = roleService.findByCondition(roleDto, pageable);
        return ResponseEntity.ok(rolePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated RoleDto roleDto, @PathVariable("id") Long id) {
        roleService.update(roleDto, id);
        return ResponseEntity.ok().build();
    }
}