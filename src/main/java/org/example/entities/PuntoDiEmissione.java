package org.example.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "punti_di_emissione")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // tutti i punti di emissione saranno elencati in una singola tabella
@DiscriminatorColumn(name = "punto_di_emissione")
@NamedQuery(name = "findEmissionPoints", query = "SELECT pe FROM PuntoDiEmissione pe")

public abstract class PuntoDiEmissione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    private String nome;

    @OneToMany(mappedBy = "puntoDiEmissione")
    protected List<Abbonamento> listaAbbonamenti = new ArrayList<>(); // abbonamenti disponibili nel punto di emissione

    @OneToMany(mappedBy = "puntoDiEmissione")
    protected List<Biglietto> listaBiglietti = new ArrayList<>(); // biglietti disponibili nel punto di emissione

    public PuntoDiEmissione(){};

    public PuntoDiEmissione(String nome) {
        this.nome = nome;
        this.listaAbbonamenti = new ArrayList<>();
        this.listaBiglietti = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Abbonamento> getListaAbbonamenti() {
        return listaAbbonamenti;
    }

    public void setListaAbbonamenti(List<Abbonamento> listaAbbonamenti) {
        this.listaAbbonamenti = listaAbbonamenti;
    }

    public List<Biglietto> getListaBiglietti() {
        return listaBiglietti;
    }

    public void setListaBiglietti(List<Biglietto> listaBiglietti) {
        this.listaBiglietti = listaBiglietti;
    }

    @Override
    public String toString() {
        return "PuntoDiEmissione{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
