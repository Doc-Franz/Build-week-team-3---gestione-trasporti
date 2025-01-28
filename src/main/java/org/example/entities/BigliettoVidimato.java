package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "biglietti_vidimati")
public class BigliettoVidimato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Biglietto biglietto;

    @ManyToOne
    private Mezzo mezzo;

    private LocalDateTime dataVidimazione;

    public BigliettoVidimato() {}

    public BigliettoVidimato(Biglietto biglietto, Mezzo mezzo) {
        this.biglietto = biglietto;
        this.mezzo = mezzo;
        this.dataVidimazione = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public LocalDateTime getDataVidimazione() {
        return dataVidimazione;
    }

    public void setDataVidimazione(LocalDateTime dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }
}
