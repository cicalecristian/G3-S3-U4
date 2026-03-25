package cristiancicale.entities;

import jakarta.persistence.*;

@Entity

@Table(name = "locations")

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "location_id")
    private long id;
    @Column(nullable = false, length = 30)
    private String nome;
    @Column(nullable = false, length = 20)
    private String citta;

    public Location() {
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
