package org.example.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utenti")

public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(unique = true)
    private String email;
    private int eta;

    @OneToOne(mappedBy = "utente") // un utente può avere al massimo una tessera
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;

    @OneToMany(mappedBy = "utente") // un utente può fare più biglietti
    private List<Biglietto> listaBiglietti;

    @OneToMany(mappedBy = "utente") // un utente può fare più abbonamenti
    private List<Abbonamento> listaAbbonamenti;

    public Utente() {};

    public Utente(String nome, String cognome, String email, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.eta = eta;
        this.tessera = null;
        this.listaBiglietti = new ArrayList<>();
        this.listaAbbonamenti = new ArrayList<>();
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public List<Biglietto> getListaBiglietti() {
        return listaBiglietti;
    }

    public void setListaBiglietti(List<Biglietto> listaBiglietti) {
        this.listaBiglietti = listaBiglietti;
    }

    public List<Abbonamento> getListaAbbonamenti() {
        return listaAbbonamenti;
    }

    public void setListaAbbonamenti(List<Abbonamento> listaAbbonamenti) {
        this.listaAbbonamenti = listaAbbonamenti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", eta=" + eta +
                '}';
    }
}
