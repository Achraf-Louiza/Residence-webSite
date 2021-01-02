package student.housing.ResidenceRental;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {
    private Long id;
    private Date dated;
    private Date datef;
    private Studio studio;
    private Client client;

    public Reservation() { super();}

    public Reservation(Date dated, Date datef) {
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

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }

    public Date getDatef() {
        return datef;
    }

    public void setDatef(Date datef) {
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
