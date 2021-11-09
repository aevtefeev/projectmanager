package ru.crmkrd.projectmanager.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.crmkrd.projectmanager.dto.RelizDto;
import ru.crmkrd.projectmanager.entity.Reliz;
import ru.crmkrd.projectmanager.mapper.RelizMapper;
import ru.crmkrd.projectmanager.repository.RelizRepository;
import ru.crmkrd.projectmanager.service.RelizService;
import ru.crmkrd.projectmanager.util.ServiceUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RelizServiceImpl implements RelizService {
    private final RelizRepository repository;
    private final RelizMapper relizMapper = null;

    public RelizServiceImpl(RelizRepository repository) {
        this.repository = repository;
       // this.relizMapper = relizMapper;
    }

    public RelizDto save(RelizDto relizDto) {
        Reliz entity = relizMapper.toEntity(relizDto);
        return relizMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public RelizDto findById(Long id) {
        return relizMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<RelizDto> findByCondition(RelizDto relizDto, Pageable pageable) {
        Page<Reliz> entityPage = repository.findAll(pageable);
        List<Reliz> entities = entityPage.getContent();
        return new PageImpl<>(relizMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public RelizDto update(RelizDto relizDto, Long id) {
        RelizDto data = findById(id);
        Reliz entity = relizMapper.toEntity(relizDto);
        ServiceUtil.copyProperties(data, entity);
        return save(relizMapper.toDto(entity));
    }
}