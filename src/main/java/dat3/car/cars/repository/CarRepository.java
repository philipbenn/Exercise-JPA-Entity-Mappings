package dat3.car.cars.repository;

import dat3.car.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query
    List<Car> findAllByBrandAndModel(String brand, String model);

    @Query("SELECT c FROM Car c ORDER BY c.bestDiscount DESC")
    List<Car> findAllOrderByMaxDiscountDesc();

    @Query("SELECT AVG(c.pricePerDay) FROM Car c")
    Double findAverageRentalPricePerDay();
}
