package org.example.entities;

import jakarta.persistence.*;
import org.example.enumerations.StatoMezzo;

import java.time.LocalDateTime;

@Entity
@Table(name = "periodi")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime inizio;

    private LocalDateTime fine;

    @Enumerated(EnumType.STRING)
    private StatoMezzo stato;

    @ManyToOne
    private Mezzo mezzo;

    public Periodo() {}

    public Periodo(LocalDateTime inizio, LocalDateTime fine, StatoMezzo stato, Mezzo mezzo) {
        this.inizio = inizio;
        this.fine = fine;
        this.stato = stato;
        this.mezzo = mezzo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getInizio() {
        return inizio;
    }

    public void setInizio(LocalDateTime inizio) {
        this.inizio = inizio;
    }

    public LocalDateTime getFine() {
        return fine;
    }

    public void setFine(LocalDateTime fine) {
        this.fine = fine;
    }

    public StatoMezzo getStato() {
        return stato;
    }

    public void setStato(StatoMezzo stato) {
        this.stato = stato;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }
}

