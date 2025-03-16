package com.example.provaconnessione.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.provaconnessione.model.Evento;
import com.example.provaconnessione.model.Sede;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findBySede(Sede sede);

}
