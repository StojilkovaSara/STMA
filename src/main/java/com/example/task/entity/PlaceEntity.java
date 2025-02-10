package com.example.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "place", schema = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Integer id;

    @Column(name = "building_name")
    private String buildingName;

    @Column(name = "room_name")
    private String roomName;

    public PlaceEntity(String buildingName, String roomName) {
        this.buildingName = buildingName;
        this.roomName = roomName;
    }
}
