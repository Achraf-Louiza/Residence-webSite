package student.housing.ResidenceRental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestWebService {
    ResidenceRepository residenceRepository;

    @Autowired
    public RestWebService(ResidenceRepository residenceRepository){
        this.residenceRepository = residenceRepository;
        residenceRepository.save(new Residence("MIS pour jeunes actifs", 100, 30, 400, 1000));
        residenceRepository.save(new Residence("August Rodin", 60, 9, 300, 765));
        residenceRepository.save(new Residence("Quai de Loire", 26, 5, 508,896));
        residenceRepository.save(new Residence("Le palatino", 11, 3, 411, 589));
        residenceRepository.save(new Residence("Rive-gauche Tolbiac", 60, 9, 300, 765));
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
}
