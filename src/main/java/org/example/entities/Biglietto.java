package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "biglietti")
@NamedQuery(name = "numberOfTickets", query = "SELECT b FROM Biglietto b WHERE b.puntoDiEmissione.id = :puntoDiEmissione_id " +
        "AND b.dataDiEmissione <= :dataFinePeriodo") // restituisce il numero di biglietti/abbonamenti venduti in un punto di emissione

public class Biglietto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dataDiEmissione;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "puntoDiEmissione_id")
    private PuntoDiEmissione puntoDiEmissione;

    public Biglietto() {};

    public Biglietto(PuntoDiEmissione puntoDiEmissione) {
        this.puntoDiEmissione = puntoDiEmissione;
        this.dataDiEmissione = getDataDiEmissione();
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

    public void setDataDiEmissione() {
        this.dataDiEmissione = LocalDate.now().plusDays((long) (Math.random() * 30));
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
                '}';
    }
}
