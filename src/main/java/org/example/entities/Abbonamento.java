package org.example.entities;

import jakarta.persistence.*;
import org.example.enumerations.TipoAbbonamento;

import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")

public class Abbonamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private TipoAbbonamento tipoAbbonamento;
    private boolean isValidated; // verifica se l'abbonamento è ancora valido
    private LocalDate dataDiEmissione;
    private LocalDate dataDiScadenza;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "puntoDiEmissione_id")
    private PuntoDiEmissione puntoDiEmissione;

    @ManyToOne
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;

    public Abbonamento(){};

    public Abbonamento(TipoAbbonamento tipoAbbonamento, PuntoDiEmissione puntoDiEmissione, Tessera tessera) {
        this.tipoAbbonamento = tipoAbbonamento;
        this.puntoDiEmissione = puntoDiEmissione;
        this.isValidated = true;
        this.dataDiEmissione = LocalDate.now();
        this.dataDiScadenza = getDataDiScadenza(tipoAbbonamento);
        this.tessera = tessera;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public LocalDate getDataDiEmissione() {
        return dataDiEmissione;
    }

    public void setDataDiEmissione(LocalDate dataDiEmissione) {
        this.dataDiEmissione = dataDiEmissione;
    }

    public LocalDate getDataDiScadenza(TipoAbbonamento tipoAbbonamento) {
        if (tipoAbbonamento == TipoAbbonamento.SETTIMANALE){
            this.dataDiScadenza = getDataDiEmissione().plusDays(7);
        } else if (tipoAbbonamento == TipoAbbonamento.MENSILE) {
            this.dataDiScadenza = getDataDiEmissione().plusDays(30);
        }
        return dataDiScadenza;
    }

    public void setDataDiScadenza(LocalDate dataDiScadenza) {
        this.dataDiScadenza = dataDiScadenza;
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

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "id=" + id +
                ", tipoAbbonamento=" + tipoAbbonamento +
                ", isValidated=" + isValidated +
                ", dataDiEmissione=" + dataDiEmissione +
                ", dataDiScadenza=" + dataDiScadenza +
                '}';
    }
}
