package com.example.provaconnessione.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.provaconnessione.model.Prenotazioni;
import com.example.provaconnessione.model.User;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazioni, Long> {
    List<Prenotazioni> findByEventoId(Long eventoId);

    List<Prenotazioni> findByUtente(User utente);
}
