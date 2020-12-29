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
}
