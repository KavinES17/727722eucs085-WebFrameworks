package com.example.cw2.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.Getter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    private int id;
    private String playerName, team;
    private int age;
}
