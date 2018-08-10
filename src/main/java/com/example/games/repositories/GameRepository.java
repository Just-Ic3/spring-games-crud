package com.example.games.repositories;

import com.example.games.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, String>{
    GameEntity findOneByIdEquals(String id);

    GameEntity findAllByNombreContains(String nombre);
}
