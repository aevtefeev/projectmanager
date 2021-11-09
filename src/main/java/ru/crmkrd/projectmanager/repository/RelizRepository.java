package ru.crmkrd.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.crmkrd.projectmanager.entity.Reliz;

@Repository
public interface RelizRepository extends JpaRepository<Reliz, Long>, JpaSpecificationExecutor<Reliz> {
}