package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.*;
import org.example.entities.*;
import org.example.enumerations.TipoAbbonamento;

public class Main
{

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_trasporti");
    public static EntityManager em = emf.createEntityManager();

    public static void main( String[] args ) {
        UtenteDAO utenteDAO = new UtenteDAO(em); // gestione degli utenti
        PuntoDiEmissioneDAO puntoDiEmissioneDAO = new PuntoDiEmissioneDAO(em); // gestione dei punti di emissione
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em); // gestione degli abbonamenti
        BigliettoDAO bigliettoDAO = new BigliettoDAO(em); // gestione dei biglietti
        TesseraDAO tesseraDAO = new TesseraDAO(em); // gestione delle tessere

        Utente u1 = new Utente("Pippo", "Franco", "pippofranco@example.com", 30);
        utenteDAO.save(u1);

        DistributoreAutomatico d1 = new DistributoreAutomatico("Distributore 1");
        RivenditoreAutorizzato r1 = new RivenditoreAutorizzato("Rivenditore 1");

        puntoDiEmissioneDAO.save(d1);
        puntoDiEmissioneDAO.save(r1);


        Biglietto b1 = new Biglietto(r1);
        bigliettoDAO.save(b1);

        Tessera t1 = new Tessera(u1);
        tesseraDAO.save(t1);

        Abbonamento a1 = new Abbonamento(TipoAbbonamento.SETTIMANALE, d1, t1);
        abbonamentoDAO.save(a1);

    }


}
