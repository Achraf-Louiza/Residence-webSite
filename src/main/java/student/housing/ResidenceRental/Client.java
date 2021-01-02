package student.housing.ResidenceRental;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    private long id;
    private String nom;
    private String statut;
    private int age;
    private String numero;
    private String adressemail;
    private List<Reservation> resrvations;

    public Client() { super();}

    public Client(String nom, String statut, int age, String numero, String adressemail) {
        this.nom = nom;
        this.statut = statut;
        this.age = age;
        this.numero = numero;
        this.adressemail = adressemail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy="client")
    public List<Reservation> getResrvations() {
        return resrvations;
    }

    public String getNom() {
        return nom;
    }

    public String getStatut() {
        return statut;
    }

    public int getAge() {
        return age;
    }

    public String getNumero() {
        return numero;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setResrvations(List<Reservation> resrvations) {
        this.resrvations = resrvations;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", statut='" + statut + '\'' +
                ", age=" + age +
                ", numero='" + numero + '\'' +
                ", adressemail='" + adressemail + '\'' +
                '}';
    }
}
