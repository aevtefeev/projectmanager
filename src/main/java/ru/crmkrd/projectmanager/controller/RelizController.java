package ru.crmkrd.projectmanager.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.crmkrd.projectmanager.dto.RelizDto;
import ru.crmkrd.projectmanager.service.impl.RelizServiceImpl;

@RequestMapping("/reliz")
@RestController
@Tag(name="Reliz", description="Rest for Reluiz")
public class RelizController {
    private final RelizServiceImpl relizService;

    public RelizController(RelizServiceImpl relizService) {
        this.relizService = relizService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated RelizDto relizDto) {
        relizService.save(relizDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelizDto> findById(@PathVariable("id") Long id) {
        RelizDto reliz = relizService.findById(id);
        return ResponseEntity.ok(reliz);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        relizService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<RelizDto>> pageQuery(RelizDto relizDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<RelizDto> relizPage = relizService.findByCondition(relizDto, pageable);
        return ResponseEntity.ok(relizPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated RelizDto relizDto, @PathVariable("id") Long id) {
        relizService.update(relizDto, id);
        return ResponseEntity.ok().build();
    }
}