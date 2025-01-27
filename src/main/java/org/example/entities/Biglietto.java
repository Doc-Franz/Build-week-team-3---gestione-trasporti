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

    @ManyToOne
    @JoinColumn(name = "puntoDiEmissione_id")
    private PuntoDiEmissione puntoDiEmissione;

    public Biglietto() {};

    public Biglietto(PuntoDiEmissione puntoDiEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
        this.dataDiEmissione = LocalDate.now();
        this.dataDiObliterazione = LocalDate.now();
        this.dataDiScadenza = dataDiObliterazione.plusDays(1);
        this.isValidated = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataDiEmissione() {
        return dataDiEmissione;
    }

    public void setDataDiEmissione(LocalDate dataDiEmissione) {
        this.dataDiEmissione = dataDiEmissione;
    }

    public LocalDate getDataDiObliterazione() {
        return dataDiObliterazione;
    }

    public void setDataDiObliterazione(LocalDate dataDiObliterazione) {
        this.dataDiObliterazione = dataDiObliterazione;
    }

    public LocalDate getDataDiScadenza() {
        return dataDiScadenza;
    }

    public void setDataDiScadenza(LocalDate dataDiScadenza) {
        this.dataDiScadenza = dataDiScadenza;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public PuntoDiEmissione getPuntoDiEmissione() {
        return puntoDiEmissione;
    }

    public void setPuntoDiEmissione(PuntoDiEmissione puntoDiEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "id=" + id +
                ", dataDiEmissione=" + dataDiEmissione +
                ", dataDiObliterazione=" + dataDiObliterazione +
                ", dataDiScadenza=" + dataDiScadenza +
                ", isValidated=" + isValidated +
                '}';
    }
}
