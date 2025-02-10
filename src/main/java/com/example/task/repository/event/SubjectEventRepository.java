package com.example.task.repository.event;

import com.example.task.entity.event.SubjectEvent;
import com.example.task.entity.event.SubjectEventId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectEventRepository extends JpaRepository<SubjectEvent, SubjectEventId> {
}
