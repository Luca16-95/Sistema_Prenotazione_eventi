package com.example.provaconnessione.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private String Descrizione;
    private Date data;
    private String orario;
    private double prezzo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sede_id", nullable = false)
    private Sede sede; // Relazione con Sede

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prenotazioni> prenotazioni;

    // @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch =
    // FetchType.LAZY)
    // private List<Recensione> recensioni;
}
