package org.example.entities;

import jakarta.persistence.*;
import org.example.enumerations.TipoAbbonamento;

@Entity
@Table(name = "abbonamenti")

public class Abbonamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private TipoAbbonamento tipoAbbonamento;
    private boolean isValidated; // verifica se l'abbonamento è ancora valido


}
