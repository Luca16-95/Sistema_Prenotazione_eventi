package com.example.provaconnessione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.provaconnessione.model.Evento;
import com.example.provaconnessione.model.Sede;
import com.example.provaconnessione.repository.EventoRepository;
import com.example.provaconnessione.repository.SedeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventoService {
    @Autowired
    private final SedeRepository sedeRepository;
    @Autowired
    private final EventoRepository eventoRepository;

    // Recupera un evento per ID
    public Evento getEventoById(Long id) {
        return eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento non trovato"));
    }

    // Recupera tutte le recensioni per un evento
    public Evento getEventoConRecensioni(Long eventoId) {
        // Carica l'evento con le recensioni associate (grazie alla relazione OneToMany)
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento non trovato con id: " + eventoId));
        return evento;
    }

    // metodo per l'admin per creare un nuovo evento
    public void saveEvento(Evento evento, Long sedeId) {
        // Recupera la sede associata all'evento tramite il suo ID
        Sede sede = sedeRepository.findById(sedeId).orElseThrow(() -> new RuntimeException("Sede non trovata"));

        // Associa la sede all'evento
        evento.setSede(sede);

        // Salva l'evento nel database
        eventoRepository.save(evento);
    }

    // metodo per la cancellazione di un evento.
    public void deleteEvento(Long eventoId) {
        // Verifica se l'evento esiste
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento non trovato"));

        // Elimina l'evento
        eventoRepository.delete(evento);
    }

    // metodo per visualizzare tutte le sedi
    public List<Evento> getAllEventi() {
        return eventoRepository.findAll();
    }
}
