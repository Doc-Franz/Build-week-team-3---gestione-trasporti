package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Abbonamento;

public class AbbonamentoDAO {

    private EntityManager em;

    public AbbonamentoDAO(EntityManager em){
        this.em = em;
    }

    public void save(Abbonamento a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }
}
