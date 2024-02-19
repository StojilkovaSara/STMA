package com.example.task.repository.event;

import com.example.task.entity.event.NonRepeatingEvent;
import com.example.task.entity.event.NonRepeatingEventId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonRepeatingEventRepository extends JpaRepository<NonRepeatingEvent, NonRepeatingEventId> {
}
