package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tessere")

public class Tessera {

    @Id
    @GeneratedValue
    private long id;

    private LocalDate dataDiEmissione;
    private LocalDate dataDiScadenza;

    @OneToOne
    @JoinColumn(name = "utente_id") // ad ogni tessera è associato un utente
    private Utente utente;

    @OneToMany(mappedBy = "tessera")
    private List<Abbonamento> listaAbbonamenti;

    public Tessera() {};

    public Tessera(Utente utente) {
        this.utente = utente;
        this.dataDiEmissione = LocalDate.now();
        this.dataDiScadenza = dataDiEmissione.plusYears(1);
        this.listaAbbonamenti = new ArrayList<>();
    }
}
