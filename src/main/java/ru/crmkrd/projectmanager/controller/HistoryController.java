package ru.crmkrd.projectmanager.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.crmkrd.projectmanager.dto.HistoryDto;
import ru.crmkrd.projectmanager.entity.History;
import ru.crmkrd.projectmanager.mapper.HistoryMapper;
import ru.crmkrd.projectmanager.service.HistoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/history")
@RestController
@Tag(name="History", description="Rest for History")
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated HistoryDto historyDto) {
        historyService.save(historyDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryDto> findById(@PathVariable("id") Long id) {
        HistoryDto history = historyService.findById(id);
        return ResponseEntity.ok(history);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        historyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<HistoryDto>> pageQuery(HistoryDto historyDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<HistoryDto> historyPage = historyService.findByCondition(historyDto, pageable);
        return ResponseEntity.ok(historyPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated HistoryDto historyDto, @PathVariable("id") Long id) {
        historyService.update(historyDto, id);
        return ResponseEntity.ok().build();
    }
}