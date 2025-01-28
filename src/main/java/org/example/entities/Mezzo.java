package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mezzi")
public class Mezzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String tipoMezzo;

    @Column(nullable = false)
    private int capienzaMezzo;

    @Column(nullable = false)
    private boolean inServizio;





    public Mezzo() {
    }

    public Mezzo(String tipoMezzo, int capienzaMezzo, boolean inServizio) {
        this.tipoMezzo = tipoMezzo;
        this.capienzaMezzo = capienzaMezzo;
        this.inServizio = inServizio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(String tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public int getCapienzaMezzo() {
        return capienzaMezzo;
    }

    public void setCapienzaMezzo(int capienzaMezzo) {
        this.capienzaMezzo = capienzaMezzo;
    }

    public boolean isInServizio() {
        return inServizio;
    }

    public void setInServizio(boolean inServizio) {
        this.inServizio = inServizio;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", tipoMezzo='" + tipoMezzo + '\'' +
                ", capienzaMezzo=" + capienzaMezzo +
                ", inServizio=" + inServizio +
                '}';
    }
}
