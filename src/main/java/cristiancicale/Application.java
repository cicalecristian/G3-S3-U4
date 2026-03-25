package cristiancicale;

import cristiancicale.dao.EventoDAO;
import cristiancicale.entities.Evento;
import cristiancicale.entities.TipoEvento;
import cristiancicale.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventoDAO eventsDAO = new EventoDAO(entityManager);

        Evento e1 = new Evento(
                "Concerto Rock",
                LocalDate.of(2026, 6, 15),
                "Concerto all'aperto con band locali",
                TipoEvento.PUBBLICO,
                500
        );

        Evento e2 = new Evento(
                "Workshop Java",
                LocalDate.of(2026, 4, 10),
                "Corso intensivo su Spring Boot",
                TipoEvento.PRIVATO,
                30
        );

        Evento e3 = new Evento(
                "Fiera del Libro",
                LocalDate.of(2026, 5, 20),
                "Evento culturale con autori e stand",
                TipoEvento.PUBBLICO,
                200
        );

        Evento e4 = new Evento(
                "Cena Aziendale",
                LocalDate.of(2026, 12, 18),
                "Cena di fine anno per i dipendenti",
                TipoEvento.PRIVATO,
                100
        );

        Evento e5 = new Evento(
                "Maratona",
                LocalDate.of(2026, 9, 5),
                "Gara podistica cittadina",
                TipoEvento.PUBBLICO,
                1000
        );

//        eventsDAO.save(e1);
//        eventsDAO.save(e2);
//        eventsDAO.save(e3);
//        eventsDAO.save(e4);
//        eventsDAO.save(e5);

        try {
            Evento e1find = eventsDAO.findById(2);
            System.out.println(e1find);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            eventsDAO.findByIdAndDelete(10);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
