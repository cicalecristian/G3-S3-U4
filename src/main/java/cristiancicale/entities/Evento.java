package cristiancicale.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

@Table(name = "events")

public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "event_id")
    private long id;
    @Column(name = "titolo", nullable = false, length = 30)
    private String titolo;
    @Column(name = "dataEvento", nullable = false, length = 30)
    private LocalDate dataEvento;
    @Column(name = "descrizione", length = 255)
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoEvento", nullable = false)
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    public Evento() {
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione,
                  TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
