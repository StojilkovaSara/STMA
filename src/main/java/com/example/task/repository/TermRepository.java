package com.example.task.repository;

import com.example.task.entity.term.TermEntity;
import com.example.task.entity.term.TermId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermRepository extends JpaRepository<TermEntity, TermId> {
}
