package com.example.task.repository.event;

import com.example.task.entity.event.HappensAtPlace;
import com.example.task.entity.event.NonRepeatingEventId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HappensAtPlaceRepository extends JpaRepository<HappensAtPlace, NonRepeatingEventId> {
}
