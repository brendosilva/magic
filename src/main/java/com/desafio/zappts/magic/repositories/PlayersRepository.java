package com.desafio.zappts.magic.repositories;


import com.desafio.zappts.magic.entities.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepository extends JpaRepository<Players, Long> {
}
