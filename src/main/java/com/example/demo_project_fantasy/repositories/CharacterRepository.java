package com.example.demo_project_fantasy.repositories;

import com.example.demo_project_fantasy.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> searchCharacterByNameOrRaceOrClass(String keyword);
}
