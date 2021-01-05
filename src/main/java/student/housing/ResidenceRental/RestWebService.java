package student.housing.ResidenceRental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestWebService {
    ResidenceRepository residenceRepository;


    @Autowired
    public RestWebService(ResidenceRepository rR){
        this.residenceRepository = rR;

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
    @GetMapping(value="/studios")
    public List<Studio> getStudios(@RequestParam String nomResidence){
        for (Residence r : residenceRepository.findAll()){
            if (r.getNom().equals(nomResidence)) {
                return r.getStudios();
            }
        }
        return null;
    }


}
