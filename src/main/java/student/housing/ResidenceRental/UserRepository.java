package student.housing.ResidenceRental;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Client, Long> {
    @Override
    List<Client> findAll();
}
