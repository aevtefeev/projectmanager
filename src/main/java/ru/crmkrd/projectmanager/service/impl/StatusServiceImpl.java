package ru.crmkrd.projectmanager.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.crmkrd.projectmanager.dto.StatusDto;
import ru.crmkrd.projectmanager.entity.Status;
import ru.crmkrd.projectmanager.mapper.StatusMapper;
import ru.crmkrd.projectmanager.repository.StatusRepository;
import ru.crmkrd.projectmanager.service.StatusService;
import ru.crmkrd.projectmanager.util.ServiceUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {
    private final StatusRepository repository;
    private final StatusMapper statusMapper = null;

    public StatusServiceImpl(StatusRepository repository) {
        this.repository = repository;
       // this.statusMapper = statusMapper;
    }

    public StatusDto save(StatusDto statusDto) {
        Status entity = statusMapper.toEntity(statusDto);
        return statusMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public StatusDto findById(Long id) {
        return statusMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<StatusDto> findByCondition(StatusDto statusDto, Pageable pageable) {
        Page<Status> entityPage = repository.findAll(pageable);
        List<Status> entities = entityPage.getContent();
        return new PageImpl<>(statusMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public StatusDto update(StatusDto statusDto, Long id) {
        StatusDto data = findById(id);
        Status entity = statusMapper.toEntity(statusDto);
        ServiceUtil.copyProperties(data, entity);
        return save(statusMapper.toDto(entity));
    }
}