package dat3.car.service;

import dat3.car.cars.dto.CarResponse;
import dat3.car.cars.entity.Car;
import dat3.car.cars.repository.CarRepository;
import dat3.car.cars.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CarServiceTest {

    @Autowired
    private CarRepository carRepository;

    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = new CarService(carRepository);
    }
}

