package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Mezzo;


public class MezzoDAO {

    private EntityManager em;

    public MezzoDAO(EntityManager em){
        this.em = em;
    }

    public void save(Mezzo m){
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
    }
}

