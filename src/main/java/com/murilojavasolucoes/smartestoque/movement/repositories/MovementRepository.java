package com.murilojavasolucoes.smartestoque.movement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilojavasolucoes.smartestoque.movement.models.Movement;

public interface MovementRepository extends JpaRepository<Movement, Integer> {

}
