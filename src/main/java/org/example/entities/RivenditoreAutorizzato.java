package org.example.entities;

import jakarta.persistence.Entity;

@Entity

public class RivenditoreAutorizzato extends PuntoDiEmissione {

    public RivenditoreAutorizzato(){};
    public RivenditoreAutorizzato(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "RivenditoreAutorizzato{" +
                "id=" + id +
                ", isActive=" + isActive +
                '}';
    }
}
