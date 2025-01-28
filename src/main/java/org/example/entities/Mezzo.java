package org.example.entities;

import jakarta.persistence.*;
import org.example.enumerations.StatoMezzo;
import org.example.enumerations.TipoMezzo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mezzi")
public class Mezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TipoMezzo tipoMezzo;

    private int capienza;

    @Enumerated(EnumType.STRING)
    private StatoMezzo stato;

    @OneToMany(mappedBy = "mezzo")
    private List<Periodo> periodi = new ArrayList<>(); // Traccia i periodi di servizio/manutenzione

    @OneToMany(mappedBy = "mezzo")
    private List<BigliettoVidimato> bigliettiVidimati = new ArrayList<>(); // Traccia i biglietti vidimati

    public Mezzo() {}

    public Mezzo(TipoMezzo tipoMezzo, int capienza, StatoMezzo stato) {
        this.tipoMezzo = tipoMezzo;
        this.capienza = capienza;
        this.stato = stato;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public StatoMezzo getStato() {
        return stato;
    }

    public void setStato(StatoMezzo stato) {
        this.stato = stato;
    }

    public List<Periodo> getPeriodi() {
        return periodi;
    }

    public void setPeriodi(List<Periodo> periodi) {
        this.periodi = periodi;
    }

    public List<BigliettoVidimato> getBigliettiVidimati() {
        return bigliettiVidimati;
    }

    public void setBigliettiVidimati(List<BigliettoVidimato> bigliettiVidimati) {
        this.bigliettiVidimati = bigliettiVidimati;
    }

    public void aggiungiPeriodo(Periodo periodo) {
        this.periodi.add(periodo);
    }

    public void vidimaBiglietto(Biglietto biglietto) {
        BigliettoVidimato bigliettoVidimato = new BigliettoVidimato(biglietto, this);
        this.bigliettiVidimati.add(bigliettoVidimato);
    }

    public long getBigliettiVidimatiInPeriodo(LocalDateTime inizio, LocalDateTime fine) {
        return this.bigliettiVidimati.stream()
                .filter(b -> b.getDataVidimazione().isAfter(inizio) && b.getDataVidimazione().isBefore(fine))
                .count();
    }
}
