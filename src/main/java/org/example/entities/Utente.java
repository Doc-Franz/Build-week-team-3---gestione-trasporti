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
    private String nome;
    private String cognome;
    @Column(unique = true)
    private String email;
    private int eta;

    @OneToOne(mappedBy = "utente") // un utente può avere al massimo una tessera
    private Tessera tessera;

    @OneToMany(mappedBy = "utente") // un utente può fare più biglietti
    private List<Biglietto> listaBiglietti = new ArrayList<>();

}
