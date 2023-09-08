package dat3.car.cars.repository;

import dat3.car.cars.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query
    boolean existsByCar_IdAndRentalDate(Long carId, LocalDate date);
}
