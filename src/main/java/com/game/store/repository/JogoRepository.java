package com.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.store.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{

}
