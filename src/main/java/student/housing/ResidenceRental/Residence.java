package student.housing.ResidenceRental;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Residence {
    private Long id;
    private String nom;
    private int n_studios;
    private int n_libres;
    private double minPrix;
    private double maxPrix;
    private String adresse;
    private String description;
    private List<Studio> studios = new ArrayList<>();;

    public Residence() { super(); }

    public Residence(String nom, int n_studios, int n_libres, float minPrix, float maxPrix, String adresse, String description) {
        this.nom = nom;
        this.n_studios = n_studios;
        this.n_libres = n_libres;
        this.minPrix = minPrix;
        this.maxPrix = maxPrix;
        this.adresse=adresse;
        this.description=description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy="residence",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public List<Studio> getStudios() {
        return studios;
    }

    public String getNom() {
        return nom;
    }

    public int getN_studios() {
        return n_studios;
    }

    public int getN_libres() {
        return n_libres;
    }

    public double getMinPrix() {
        return minPrix;
    }

    public double getMaxPrix() {
        return maxPrix;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId(Long id) { this.id = id; }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setN_studios(int n_studios) {
        this.n_studios = n_studios;
    }

    public void setN_libres(int n_libres) {
        this.n_libres = n_libres;
    }

    public void setMinPrix(double minPrix) {
        this.minPrix = minPrix;
    }

    public void setMaxPrix(double maxPrix) {
        this.maxPrix = maxPrix;
    }

    public void setStudios(List<Studio> studios) {
        this.studios = studios;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Residence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", n_studios=" + n_studios +
                ", n_libres=" + n_libres +
                ", minPrix=" + minPrix +
                ", maxPrix=" + maxPrix +
                '}';
    }
}
