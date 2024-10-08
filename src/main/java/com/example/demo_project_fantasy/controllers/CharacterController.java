package com.example.demo_project_fantasy.controllers;

import com.example.demo_project_fantasy.services.CharacterService;
import com.example.demo_project_fantasy.entities.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters")
    public ResponseEntity<List<Character>> characterList(){
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<Character> characterById(@PathVariable Long id){
        Optional<Character> characterOptional = characterService.getCharacterById(id);
        if (characterOptional.isPresent()){
            return ResponseEntity.ok(characterOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/characters/search")
    public ResponseEntity<List<Character>> serchCharactersByKeyword(@RequestParam String keyword){
        List<Character> characterList = characterService.searchCharactersByKeyword(keyword);
        if (characterList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(characterList);
    }

    @PostMapping("/createNewCharacter")
    public ResponseEntity<Character> newCharacter(@RequestBody Character newCharacter){
        return ResponseEntity.ok(characterService.createCharacter(newCharacter));
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Optional<Character>> updateCharacter(@PathVariable Long id, @RequestBody Character newCharacter){
        Optional<Character> characterUpdate = characterService.updateCharacter(id, newCharacter);
        if (characterUpdate.isPresent()){
            return ResponseEntity.ok(characterUpdate);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCharacterById(@PathVariable Long id){
        Optional<Character> isDeleted = characterService.deleteCharacterById(id);
        if (isDeleted.isPresent()){
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
