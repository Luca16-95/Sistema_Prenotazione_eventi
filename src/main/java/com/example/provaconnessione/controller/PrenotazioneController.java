package com.example.provaconnessione.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.provaconnessione.model.Evento;
import com.example.provaconnessione.model.Prenotazioni;
import com.example.provaconnessione.model.User;
import com.example.provaconnessione.repository.UserRepository;
import com.example.provaconnessione.service.EventoService;
import com.example.provaconnessione.service.PrenotazioneService;
import com.example.provaconnessione.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;
    private final UserService userService;
    private final EventoService eventoService;

    @GetMapping("/evento/{eventoId}")
    public String listaPrenotazioni(Model model, Long eventoId) {
        List<Prenotazioni> prenotazioni = prenotazioneService.getPrenotazioniByEvento(eventoId);
        model.addAttribute("prenotazioni", prenotazioni);
        return "prenotazioni"; // Template per visualizzare le prenotazioni
    }

    @PostMapping("/prenota")
    public String prenotaEvento(@RequestParam("eventoId") Long eventoId,
            @RequestParam("biglietti") Long numeroBiglietti,
            Model model) {

        // Recupera l'utente loggato
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Ottieni il nome utente (username)
        User utente = userService.getUserByUsername(username);

        // Recupera l'evento
        Evento evento = eventoService.getEventoById(eventoId);

        // Crea una nuova prenotazione
        Prenotazioni prenotazione = new Prenotazioni();
        prenotazione.setEvento(evento);
        prenotazione.setUtente(utente);
        prenotazione.setData(evento.getData());
        prenotazione.setNumeroBiglietti(numeroBiglietti);

        // Salva la prenotazione
        prenotazioneService.save(prenotazione);

        // Aggiungi un messaggio di successo alla vista
        model.addAttribute("message", "Prenotazione effettuata con successo!");
        return "redirect:/eventi"; // Puoi reindirizzare l'utente alla lista degli eventi o a una pagina di
                                   // conferma
    }
}
