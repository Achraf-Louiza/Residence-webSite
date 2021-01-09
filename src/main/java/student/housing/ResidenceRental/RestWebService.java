package student.housing.ResidenceRental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestWebService {

    ResidenceRepository residenceRepository;
    UserRepository userRepository;
    ReservationRepository reservationRepository;
    Client lastClient;
    Studio chosenStudio;

    @Autowired
    public RestWebService(ResidenceRepository rR, UserRepository uR, ReservationRepository reservationRepository){
        this.residenceRepository = rR;
        this.userRepository = uR;
        this.reservationRepository=reservationRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/residences")
    public List<Residence> getResidences(){ return residenceRepository.findAll(); }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/residences/{nomResidence}")
    public Residence getResidence(@PathVariable(value= "nomResidence" ) String nomResidence){
        for (Residence r : residenceRepository.findAll()){
            if (r.getNom().equals(nomResidence)) {
                return r;
            }
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/users")
    public List<Client> getUsers(){ return userRepository.findAll(); }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/studios")
    public List<Studio> getStudios(@RequestParam String nomResidence){
        for (Residence r : residenceRepository.findAll()){
            if (r.getNom().equals(nomResidence)) {
                return r.getStudios();
            }
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/reservations")
    public List<Reservation> getReservations(@RequestParam String nomUser){
        for (Client c : userRepository.findAll()){
            if (c.getNom().equals(nomUser)) {
                return c.getReservations();
            }
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/user")
    public void addUser(@RequestBody Client client) throws Exception{
        this.lastClient=client;
        System.out.println(this.lastClient);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/studio")
    public void receiveStudio(@RequestBody Studio studio) throws Exception{
        System.out.println(studio);
        this.chosenStudio = studio;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/reservation")
    public void addReservation(@RequestBody Reservation reservation) throws Exception{
        boolean exist = false;
        System.out.println(reservation);
        reservation.setStudio(this.chosenStudio);
        this.chosenStudio.getReservations().add(reservation);
        for (Client c : this.userRepository.findAll()) {
            if (c.getNom().equals(this.lastClient.getNom()) && c.getPrenom().equals(this.lastClient.getPrenom())) {
                exist = true;
                this.lastClient=c;
            }
        }
        if (exist==true){
            reservation.setClient(this.lastClient);
            this.lastClient.getReservations().add(reservation);
            this.reservationRepository.save(reservation);
        }else{
            reservation.setClient(this.lastClient);
            this.lastClient.getReservations().add(reservation);
            this.userRepository.save(this.lastClient);
            }


    }




}
