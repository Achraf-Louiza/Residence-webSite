package student.housing.ResidenceRental;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResidenceRepository extends CrudRepository<Residence, Long>{
    @Override
    List<Residence> findAll();
}
