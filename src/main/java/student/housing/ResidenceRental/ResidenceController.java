package student.housing.ResidenceRental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResidenceController {
    ResidenceRepository residenceRepository;

    @Autowired
    public ResidenceController(ResidenceRepository residenceRepository){
        this.residenceRepository = residenceRepository;
        residenceRepository.save(new Residence("R1", 100, 30, 400, 1000));
        residenceRepository.save(new Residence("R2", 60, 9, 300, 765));
    }

    @GetMapping(value="/residences")
    public List<Residence> getResidences(){ return residenceRepository.findAll(); }

    @GetMapping(value="/residences/{nomResidence}")
    public Residence getCar(@PathVariable(value= "nomResidence" ) String nomResidence){
        for (Residence r : residenceRepository.findAll()){
            if (r.getNom().equals(nomResidence)) {
                return r;
            }
        }
        return null;
    }
}
