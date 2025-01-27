package org.example.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.example.entities.Biglietto;

public class BigliettoDAO {

    private EntityManager em;

    public BigliettoDAO(EntityManager em){
        this.em = em;
    }

    public void save(Biglietto b){
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
    }
}
