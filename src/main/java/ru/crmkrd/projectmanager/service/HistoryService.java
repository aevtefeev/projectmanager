package ru.crmkrd.projectmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.crmkrd.projectmanager.dto.HistoryDto;
import ru.crmkrd.projectmanager.entity.History;
import ru.crmkrd.projectmanager.mapper.HistoryMapper;
import ru.crmkrd.projectmanager.repository.HistoryRepository;
import ru.crmkrd.projectmanager.util.ServiceUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HistoryService {
    private final HistoryRepository repository;
    private final HistoryMapper historyMapper = null;

    public HistoryService(HistoryRepository repository) {
        this.repository = repository;
        //this.historyMapper = historyMapper;
    }

    public HistoryDto save(HistoryDto historyDto) {
        History entity = historyMapper.toEntity(historyDto);
        return historyMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public HistoryDto findById(Long id) {
        return historyMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<HistoryDto> findByCondition(HistoryDto historyDto, Pageable pageable) {
        Page<History> entityPage = repository.findAll(pageable);
        List<History> entities = entityPage.getContent();
        return new PageImpl<>(historyMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public HistoryDto update(HistoryDto historyDto, Long id) {
        HistoryDto data = findById(id);
        History entity = historyMapper.toEntity(historyDto);
        ServiceUtil.copyProperties(data, entity);
        return save(historyMapper.toDto(entity));
    }
}