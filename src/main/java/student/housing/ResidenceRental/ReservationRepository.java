package student.housing.ResidenceRental;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    @Override
    List<Reservation> findAll();
}
