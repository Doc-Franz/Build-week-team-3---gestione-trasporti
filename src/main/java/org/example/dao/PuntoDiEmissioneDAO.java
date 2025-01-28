package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.PuntoDiEmissione;

public class PuntoDiEmissioneDAO {

    private EntityManager em;

    public PuntoDiEmissioneDAO(EntityManager em){
        this.em = em;
    }

    public void save(PuntoDiEmissione pe){
        em.getTransaction().begin();
        em.persist(pe);
        em.getTransaction().commit();
    }

    public PuntoDiEmissione findById(int id){
        return em.find(PuntoDiEmissione.class, id);
    }
}
