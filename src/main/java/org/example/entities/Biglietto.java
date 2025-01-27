package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "biglietti")

public class Biglietto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dataDiEmissione;
    private LocalDate dataDiObliterazione;
    private LocalDate dataDiScadenza;
    private boolean isValidated; // verifica che il biglietto sia validato o meno

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

}
