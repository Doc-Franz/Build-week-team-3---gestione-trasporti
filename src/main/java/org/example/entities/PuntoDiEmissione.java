package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "punti_di_emissione")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // tutti i punti di emissione saranno elencati in una singola tabella
@DiscriminatorColumn(name = "punto_di_emissione")

public abstract class PuntoDiEmissione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private boolean isActive; // verifica se il punto di emissione è attivo o meno

}
