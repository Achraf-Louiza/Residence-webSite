package student.housing.ResidenceRental;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Studio {
    private Long id;
    private String type;
    private double superficie;
    private double prixmois;
    private double prixcaution;
    private int n_occurence;
    private int n_libres;
    private Residence residence;
    private List<Reservation> reservations = new ArrayList<>();

    public Studio(){ super();}

    public Studio(String type, double superficie, double prixmois, double prixcaution, int n_occurence, int n_libres) {
        this.type= type;
        this.superficie = superficie;
        this.prixmois = prixmois;
        this.prixcaution = prixcaution;
        this.n_occurence = n_occurence;
        this.n_libres = n_libres;

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

    @OneToMany(mappedBy="studio", cascade=CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
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

    public int getN_occurence() {
        return n_occurence;
    }

    public void setN_occurence(int n_occurence) {
        this.n_occurence = n_occurence;
    }

    public int getN_libres() {
        return n_libres;
    }

    public void setN_libres(int n_libres) {
        this.n_libres = n_libres;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                '}';
    }
}
