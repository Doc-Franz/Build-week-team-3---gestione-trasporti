package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.*;
import org.example.entities.*;
import org.example.enumerations.TipoAbbonamento;

public class Main
{

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_trasporti"); // apertura della connessione al database
    public static EntityManager em = emf.createEntityManager(); // interazione con il database

    public static UtenteDAO utenteDAO = new UtenteDAO(em); // gestione degli utenti
    public static PuntoDiEmissioneDAO puntoDiEmissioneDAO = new PuntoDiEmissioneDAO(em); // gestione dei punti di emissione
    public static AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em); // gestione degli abbonamenti
    public static BigliettoDAO bigliettoDAO = new BigliettoDAO(em); // gestione dei biglietti
    public static TesseraDAO tesseraDAO = new TesseraDAO(em); // gestione delle tessere

    public static Faker fk = new Faker();

    public static void main( String[] args ) {

        generateUsers(); // generazione di una tabella di utenti con tessere associate
        generateEmissionPoints(); // generazione di una tabella di punti di emissione

        //Biglietto b1 = new Biglietto(r1);
        //bigliettoDAO.save(b1);

        //Abbonamento a1 = new Abbonamento(TipoAbbonamento.SETTIMANALE, d1, t1);
        //abbonamentoDAO.save(a1);

    }

    // funzione che genera una tabella di utenti
    public static void generateUsers(){
        for (int i = 0; i < 30; i++){
            double randomChoice = Math.random(); // variabile che controlla se associare o meno la tessera ad un utente (se > 0.5 l'utente avrà una tessera associata
            Utente u = new Utente(fk.name().firstName(), fk.name().lastName(), fk.internet().emailAddress() , (int) (14 + (Math.random() * 60)));
            utenteDAO.save(u);
            if (randomChoice > 0.5){
                tesseraDAO.save(new Tessera(u));
            }
        }
    }

    // funzione che genera una tabella di punti di emissione
    public static void generateEmissionPoints(){
        for (int i = 0; i < 10; i++){
            DistributoreAutomatico d = new DistributoreAutomatico(fk.address().streetName());
            puntoDiEmissioneDAO.save(d);
            puntoDiEmissioneDAO.save(new RivenditoreAutorizzato(fk.address().streetName()));
        }
    }


}
