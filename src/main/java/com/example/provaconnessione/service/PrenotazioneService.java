package com.example.provaconnessione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.provaconnessione.model.Evento;
import com.example.provaconnessione.model.Prenotazioni;
import com.example.provaconnessione.model.User;
import com.example.provaconnessione.repository.PrenotazioneRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {
    @Autowired
    private final PrenotazioneRepository prenotazioneRepository;

    public void save(Prenotazioni prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazioni> getPrenotazioniByEvento(Long eventoId) {
        return prenotazioneRepository.findByEventoId(eventoId);
    }
}
