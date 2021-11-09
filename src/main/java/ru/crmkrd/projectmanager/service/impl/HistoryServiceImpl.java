package ru.crmkrd.projectmanager.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.crmkrd.projectmanager.dto.history.HistoryRequestDto;
import ru.crmkrd.projectmanager.entity.History;
import ru.crmkrd.projectmanager.mapper.HistoryMapper;
import ru.crmkrd.projectmanager.repository.HistoryRepository;
import ru.crmkrd.projectmanager.service.HistoryService;
import ru.crmkrd.projectmanager.util.ServiceUtil;
//import ru.crmkrd.projectmanager.service.HistoryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository repository;
    private final HistoryMapper historyMapper = null;

    public HistoryServiceImpl(HistoryRepository repository) {
        this.repository = repository;
        //this.historyMapper = historyMapper;
    }

    public HistoryRequestDto save(HistoryRequestDto historyDto) {
        History entity = historyMapper.toEntity(historyDto);
        return historyMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public HistoryRequestDto findById(Long id) {
        return historyMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<HistoryRequestDto> findByCondition(HistoryRequestDto historyDto, Pageable pageable) {
        Page<History> entityPage = repository.findAll(pageable);
        List<History> entities = entityPage.getContent();
        return new PageImpl<>(historyMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public HistoryRequestDto update(HistoryRequestDto historyDto, Long id) {
        HistoryRequestDto data = findById(id);
        History entity = historyMapper.toEntity(historyDto);
        ServiceUtil.copyProperties(data, entity);
        return save(historyMapper.toDto(entity));
    }
}