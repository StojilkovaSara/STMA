package com.example.task.repository;

import com.example.task.entity.schoolyear.SchoolYearEntity;
import com.example.task.entity.schoolyear.SchoolYearId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolYearRepository extends JpaRepository<SchoolYearEntity, SchoolYearId> {

}
