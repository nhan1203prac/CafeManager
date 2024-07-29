package com.java.finalProject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.finalProject.model.tables;

public interface TableRepository extends JpaRepository<tables, Long> {
    List<tables> findByAreaAreaId(Long areaId);
    tables findByTableName(String tableName);
}
