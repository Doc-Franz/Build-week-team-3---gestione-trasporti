package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.dao.*;
import org.example.entities.*;
import org.example.enumerations.TipoAbbonamento;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main
{

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_trasporti"); // apertura della connessione al database
    public static EntityManager em = emf.createEntityManager(); // interazione con il database

    public static UtenteDAO utenteDAO = new UtenteDAO(em); // gestione degli utenti
    public static PuntoDiEmissioneDAO puntoDiEmissioneDAO = new PuntoDiEmissioneDAO(em); // gestione dei punti di emissione
    public static AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em); // gestione degli abbonamenti
    public static BigliettoDAO bigliettoDAO = new BigliettoDAO(em); // gestione dei biglietti
    public static TesseraDAO tesseraDAO = new TesseraDAO(em); // gestione delle tessere

    public static Faker fk = new Faker(new Locale("it"));
    public static Scanner sc = new Scanner(System.in);

    public static void main( String[] args ) {

        // generateUsers(); // generazione di una tabella di utenti con tessere associate
        generateEmissionPoints(); // generazione di una tabella di punti di emissione

        // generazione di un utente dotato di tessera
        Utente u1 = new Utente(fk.name().firstName(), fk.name().lastName(), fk.internet().emailAddress() , (int) (14 + (Math.random() * 60)));
        Tessera t1 = new Tessera(u1);
        tesseraDAO.save(t1);
        //Abbonamento a1 = new Abbonamento(fk.options().option(TipoAbbonamento.values()), pe, t1);
        utenteDAO.save(u1);

        // generazione di un utente senza tessera
        Utente u2 = new Utente(fk.name().firstName(), fk.name().lastName(), fk.internet().emailAddress() , (int) (14 + (Math.random() * 60))); // Utente senza tessera
        utenteDAO.save(u2);

        checkNumberOfTickets();

        //Abbonamento a1 = new Abbonamento(TipoAbbonamento.SETTIMANALE, d1, t1);
        //abbonamentoDAO.save(a1);

    }

    // funzione che genera una tabella di punti di emissione
    public static void generateEmissionPoints(){
        for (int i = 0; i < 5; i++){
            DistributoreAutomatico d = new DistributoreAutomatico(fk.address().streetName(), new Random().nextBoolean());
            puntoDiEmissioneDAO.save(d);
            if (!d.isOutOfService()) // se il distributore è in servizio può generare biglietti
            {
                generateTickets(d);
            } // per ogni distributore automatico verranno generati n biglietti

            RivenditoreAutorizzato r = new RivenditoreAutorizzato(fk.address().streetName());
            puntoDiEmissioneDAO.save(r);
            generateTickets(r); // per ogni distributore automatico verranno generati n biglietti
        }
    }

    // funzione che genera n biglietti per ogni punto di emissione
    public static void generateTickets(PuntoDiEmissione pe){
        for (int i = 0; i < Math.random() * 10; i ++){
            Biglietto b = new Biglietto(pe);
            bigliettoDAO.save(b);
        }
    }

    // funzione che genera una tabella di utenti
    public static void generateUsers(){
        for (int i = 0; i < 3; i++){
            double randomChoice = Math.random(); // variabile che controlla se associare o meno la tessera ad un utente (se > 0.5 l'utente avrà una tessera associata
            Utente u = new Utente(fk.name().firstName(), fk.name().lastName(), fk.internet().emailAddress() , (int) (14 + (Math.random() * 60)));
            utenteDAO.save(u);
            if (randomChoice > 0.5){
                tesseraDAO.save(new Tessera(u));
            }
        }
    }

    // funzione che controlla i biglietti/abbonamenti emessi per punto di emissione in un periodo di tempo
    public static void checkNumberOfTickets(){
        long userInput; // variabile che controlla i valori inseriti dall'utente
        Query showEmissionPoints = em.createNamedQuery("findEmissionPoints", PuntoDiEmissione.class); //ricerca di tutti i punti di emissione
        List<PuntoDiEmissione> listaPuntiDiEmissione = showEmissionPoints.getResultList(); //creazione di una lista dei punti di emissione presenti nel database
        System.out.println("Questa è la lista dei punti di emissione:");
        System.out.println("");
        listaPuntiDiEmissione.forEach(System.out::println);
        System.out.println("");

        System.out.print("Inserisci l'id del punto di emissione per cui vuoi controllare il numero di abbonamenti/biglietti emessi: ");
        userInput = Long.parseLong(sc.nextLine());

        System.out.print("Quanti giorni vuoi controllare a partire da oggi? ");
        userInput = Long.parseLong(sc.nextLine());

        LocalDate dateToCheck = LocalDate.now().plusDays(userInput);
        Query showNumOfTickets = em.createNamedQuery("numberOfTickets", Biglietto.class);
        showNumOfTickets.setParameter("puntoDiEmissione_id", userInput);
        showNumOfTickets.setParameter("dataFinePeriodo", dateToCheck);
        System.out.println(showNumOfTickets.getResultList());
    }

    public static void chooseUser(){
        long userInput;
        Query showUsers = em.createNamedQuery("findUsers", Utente.class); //ricerca di tutti gli utenti
        List<Utente> listaUtenti = showUsers.getResultList(); //creazione di una lista degli utenti presenti nel database
        System.out.println("Questa è la lista degli utenti registrati:");
        System.out.println("");
        listaUtenti.forEach(System.out::println);
        System.out.println("");
        System.out.println("Seleziona l'ID dell'utente per il quale compiere le azioni: ");
        userInput = Long.parseLong(sc.nextLine());
    }


}
