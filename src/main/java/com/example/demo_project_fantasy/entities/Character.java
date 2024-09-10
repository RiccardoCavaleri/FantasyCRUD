package com.example.demo_project_fantasy.entities;


import jakarta.persistence.*;

@Entity
@Table
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String race;
    private String className;
    private Integer level;
    private String description;

    public Character() {}

    public Character(String name, String race, String className, Integer level, String description) {
        this.name = name;
        this.race = race;
        this.className = className;
        this.level = level;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
