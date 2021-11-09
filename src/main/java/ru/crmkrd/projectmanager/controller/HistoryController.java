package ru.crmkrd.projectmanager.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.crmkrd.projectmanager.dto.history.HistoryRequestDto;
import ru.crmkrd.projectmanager.service.impl.HistoryServiceImpl;


@RequestMapping("/api/history")
@RestController
@Tag(name= "History", description = "Rest for History")
public class HistoryController  {
    private final HistoryServiceImpl historyServiceImpl;

    public HistoryController(HistoryServiceImpl historyServiceImpl) {
        this.historyServiceImpl = historyServiceImpl;
    }


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated HistoryRequestDto historyDto) {
        historyServiceImpl.save(historyDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryRequestDto> findById(@PathVariable("id") Long id) {
        HistoryRequestDto history = historyServiceImpl.findById(id);
        return ResponseEntity.ok(history);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        historyServiceImpl.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<HistoryRequestDto>> pageQuery(HistoryRequestDto historyDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<HistoryRequestDto> historyPage = historyServiceImpl.findByCondition(historyDto, pageable);
        return ResponseEntity.ok(historyPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated HistoryRequestDto historyDto, @PathVariable("id") Long id) {
        historyServiceImpl.update(historyDto, id);
        return ResponseEntity.ok().build();
    }
}