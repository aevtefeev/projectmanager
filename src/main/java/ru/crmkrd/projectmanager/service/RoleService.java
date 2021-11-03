package ru.crmkrd.projectmanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ru.crmkrd.projectmanager.dto.RoleDto;
import ru.crmkrd.projectmanager.entity.Role;
import ru.crmkrd.projectmanager.mapper.RoleMapper;
import ru.crmkrd.projectmanager.repository.RoleRepository;
import ru.crmkrd.projectmanager.util.ServiceUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class RoleService {
    private final RoleRepository repository;
    private final RoleMapper roleMapper = null;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
   //     this.roleMapper = roleMapper;
    }

    public RoleDto save(RoleDto roleDto) {
        Role entity = roleMapper.toEntity(roleDto);
        return roleMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public RoleDto findById(Long id) {
        return roleMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<RoleDto> findByCondition(RoleDto roleDto, Pageable pageable) {
        Page<Role> entityPage = repository.findAll(pageable);
        List<Role> entities = entityPage.getContent();
        return new PageImpl<>(roleMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public RoleDto update(RoleDto roleDto, Long id) {
        RoleDto data = findById(id);
        Role entity = roleMapper.toEntity(roleDto);
        ServiceUtil.copyProperties(data, entity);
        return save(roleMapper.toDto(entity));
    }
}