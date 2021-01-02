package student.housing.ResidenceRental;

import javax.persistence.*;
import java.util.List;

@Entity
public class Studio {
    private Long id;
    private double superficie;
    private double prixmois;
    private double prixcaution;
    private Long n_occurence;
    private Long n_libres;
    private String description;
    private Residence residence;
    private List<Reservation> reservations;

    public Studio(){ super();}

    public Studio(Long resid, double superficie, double prixmois, double prixcaution, Long n_occurence, Long n_libres, String description) {
        this.superficie = superficie;
        this.prixmois = prixmois;
        this.prixcaution = prixcaution;
        this.n_occurence = n_occurence;
        this.n_libres = n_libres;
        this.description = description;
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
    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    @OneToMany(mappedBy="studio")
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getPrixmois() {
        return prixmois;
    }

    public void setPrixmois(double prixmois) {
        this.prixmois = prixmois;
    }

    public double getPrixcaution() {
        return prixcaution;
    }

    public void setPrixcaution(double prixcaution) {
        this.prixcaution = prixcaution;
    }

    public Long getN_occurence() {
        return n_occurence;
    }

    public void setN_occurence(Long n_occurence) {
        this.n_occurence = n_occurence;
    }

    public Long getN_libres() {
        return n_libres;
    }

    public void setN_libres(Long n_libres) {
        this.n_libres = n_libres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", superficie=" + superficie +
                ", prixmois=" + prixmois +
                ", prixcaution=" + prixcaution +
                ", n_occurence=" + n_occurence +
                ", n_libres=" + n_libres +
                ", description='" + description + '\'' +
                '}';
    }
}
