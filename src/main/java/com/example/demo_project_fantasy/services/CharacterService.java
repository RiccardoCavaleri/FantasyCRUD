package com.example.demo_project_fantasy.services;

import com.example.demo_project_fantasy.entities.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    List<Character> getAllCharacters();
    Optional<Character> getCharacterById(Long id);
    Character createCharacter(Character character);
    public Character updateCharacter(Long id, Character character);
    List<Character> searchCharactersByKeyword(String keyword);
    Optional<Character> deleteCharacterById(Long id);
}
