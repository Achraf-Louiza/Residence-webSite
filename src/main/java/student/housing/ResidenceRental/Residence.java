package student.housing.ResidenceRental;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Residence {
    private Long id;
    private String nom;
    private int n_studios;
    private int n_libres;
    private double minPrix;
    private double maxPrix;

    public Residence() { super(); }

    public Residence(String nom, int n_studios, int n_libres, float minPrix, float maxPrix) {
        this.nom = nom;
        this.n_studios = n_studios;
        this.n_libres = n_libres;
        this.minPrix = minPrix;
        this.maxPrix = maxPrix;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
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
