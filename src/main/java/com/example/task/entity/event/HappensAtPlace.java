package com.example.task.entity.event;

import com.example.task.entity.PlaceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "happens_at_place", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HappensAtPlace {

    @EmbeddedId
    private NonRepeatingEventId id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity place;
}
