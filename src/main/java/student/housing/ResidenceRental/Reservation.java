package student.housing.ResidenceRental;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Reservation {
    private Long id;
    private LocalDate dated;
    private LocalDate datef;
    private Studio studio;
    private Client client;

    public Reservation() { super();}

    public Reservation(LocalDate dated, LocalDate datef) {
        this.dated = dated;
        this.datef = datef;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDated() {
        return dated;
    }

    public void setDated(LocalDate dated) {
        this.dated = dated;
    }

    public LocalDate getDatef() {
        return datef;
    }

    public void setDatef(LocalDate datef) {
        this.datef = datef;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dated=" + dated +
                ", datef=" + datef +
                '}';
    }
}
