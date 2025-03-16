package com.example.provaconnessione.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prenotazione")
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private Long numeroBiglietti;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private User utente; // Relazione con Utente

    @ManyToOne
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Evento evento; // Relazione con Evento
}
