package com.example.demo_project_fantasy.services;

import com.example.demo_project_fantasy.repositories.CharacterRepository;
import com.example.demo_project_fantasy.entities.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;


    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }


    public Optional<Character> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }


    public Character createCharacter(Character character) {
        return characterRepository.save(character);

    }


    public Optional<Character>  updateCharacter(Long id, Character character) {
        Optional<Character> existingCharacterOptional = characterRepository.findById(id);
        if (existingCharacterOptional.isPresent()) {
            Character characterToUpdate = existingCharacterOptional.get();

            characterToUpdate.setName(character.getName());
            characterToUpdate.setDescription(character.getDescription());
            characterToUpdate.setLevel(character.getLevel());
            characterToUpdate.setRace(character.getRace());
            characterToUpdate.setClassName(character.getClassName());
            return Optional.of(characterRepository.save(characterToUpdate));
        }else {
            return Optional.empty();
        }

    }

    public List<Character> searchCharactersByKeyword(String keyword) {
        return characterRepository.searchCharacterByNameOrRaceOrClass(keyword);
    }


    public Optional<Character> deleteCharacterById(Long id) {
        Optional<Character> characterOptional = characterRepository.findById(id);
        if (characterOptional.isPresent()) {
            characterRepository.deleteById(id);
            return characterOptional;
        }
        return Optional.empty();
    }

}
