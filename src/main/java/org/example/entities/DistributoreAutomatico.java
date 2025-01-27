package org.example.entities;

import jakarta.persistence.Entity;

@Entity

public class DistributoreAutomatico extends PuntoDiEmissione {

    public DistributoreAutomatico(){};
    public DistributoreAutomatico(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                "id=" + id +
                ", isActive=" + isActive +
                '}';
    }
}
