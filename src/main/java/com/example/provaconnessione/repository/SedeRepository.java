package com.example.provaconnessione.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.provaconnessione.model.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {

    boolean existsByNome(String nome);
}
