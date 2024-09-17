package com.example.demo_project_fantasy.repositories;

import com.example.demo_project_fantasy.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

        @Query("SELECT c FROM Character c WHERE c.name LIKE %:keyword% OR c.race LIKE %:keyword% OR c.className LIKE %:keyword%")
        List<Character> searchCharacterByNameOrRaceOrClass(@Param("keyword") String keyword);

}
