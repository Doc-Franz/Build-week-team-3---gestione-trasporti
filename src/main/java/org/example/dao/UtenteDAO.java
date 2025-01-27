package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Utente;

public class UtenteDAO {

    private EntityManager em;

    public UtenteDAO(EntityManager em){
        this.em = em;
    }

    public void save(Utente u){
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }
}
