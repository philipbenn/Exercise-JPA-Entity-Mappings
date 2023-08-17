package dat3.car;

import dat3.car.cars.entity.Car;
import dat3.car.cars.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarTest {

    @Autowired
    CarRepository carRepository;

    @Test
    public void testSaveAndFindCars() {
        Car car1 = new Car("Audi", "RS6", 100, 10);
        Car car2 = new Car("BMW", "M3", 60, 15);
        carRepository.save(car1);
        carRepository.save(car2);

        List<Car> cars = carRepository.findAll();
        assertThat(cars).hasSize(2);
    }

    @Test
    public void testUpdateCar() {
        Car car3 = new Car("Peugeot", "107", 20, 30);
        Car savedCar = carRepository.save(car3);

        savedCar.setBrand("Ford");
        carRepository.save(savedCar);

        assertThat(savedCar.getBrand()).isEqualTo("Ford");
    }
}
