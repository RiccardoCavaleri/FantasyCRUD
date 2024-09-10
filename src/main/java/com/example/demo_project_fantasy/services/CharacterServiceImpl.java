package com.example.demo_project_fantasy.services;

import com.example.demo_project_fantasy.entities.Character;
import com.example.demo_project_fantasy.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public Optional<Character> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    @Override
    public Character createCharacter(Character character) {
        return characterRepository.save(character);

    }

    @Override
    public Character updateCharacter(Long id, Character character) {
        Optional<Character> existingCharacterOptional = characterRepository.findById(id);
        if (existingCharacterOptional.isPresent()) {
            Character characterToUpdate = existingCharacterOptional.get();

            characterToUpdate.setName(character.getName());
            characterToUpdate.setDescription(character.getDescription());
            characterToUpdate.setLevel(character.getLevel());
            characterToUpdate.setRace(character.getRace());
            characterToUpdate.setClassName(character.getClassName());
            return characterRepository.save(characterToUpdate);
        }
        return new Character();
    }

    @Override
    public List<Character> searchCharactersByKeyword(String keyword) {
        return characterRepository.serchCharacterByNameOrRaceOrClass(keyword);
    }

    @Override
    public Optional<Character> deleteCharacterById(Long id) {
        Optional<Character> characterOptional = characterRepository.findById(id);
        if (characterOptional.isPresent()){
            characterRepository.deleteById(id);
            return characterOptional;
        }
        return Optional.empty();
    }

}
