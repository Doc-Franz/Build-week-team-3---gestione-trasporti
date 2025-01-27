package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Tessera;

public class TesseraDAO {

    private EntityManager em;

    public TesseraDAO(EntityManager em){
        this.em = em;
    }

    public void save(Tessera t){
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }
}
