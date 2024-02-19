package com.example.task.repository.event;

import com.example.task.entity.event.NonRepeatingEventId;
import com.example.task.entity.event.RepeatingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepeatingEventRepository extends JpaRepository<RepeatingEvent, NonRepeatingEventId> {
}
