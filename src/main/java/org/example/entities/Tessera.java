package org.example.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Tessera {

    @Id
    @GeneratedValue
    private long id;

    private LocalDate dataDiEmissione;
    private LocalDate dataDiScadenza;

    @OneToOne
    @JoinColumn(name = "utente_id") // ad ogni tessera è associato un utente
    private Utente utente;


}
