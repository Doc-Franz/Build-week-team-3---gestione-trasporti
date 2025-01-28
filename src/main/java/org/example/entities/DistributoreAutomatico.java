package org.example.entities;

import jakarta.persistence.Entity;

import java.util.Random;

@Entity

public class DistributoreAutomatico extends PuntoDiEmissione {

    private boolean outOfService;

    public DistributoreAutomatico(){};
    public DistributoreAutomatico(String nome, boolean outOfService) {
        super(nome);
        this.outOfService = outOfService;
    }

    public boolean isOutOfService() {
        return outOfService;
    }

    public void setOutOfService(boolean outOfService) {
        this.outOfService = outOfService;
    }

    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                "id=" + id +
                '}';
    }
}
