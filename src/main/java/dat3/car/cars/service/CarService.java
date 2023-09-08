package dat3.car.cars.service;

import dat3.car.cars.dto.CarRequest;
import dat3.car.cars.dto.CarResponse;
import dat3.car.cars.entity.Car;
import dat3.car.cars.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    // Constructor Injection
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Service Methods
    public List<CarResponse> getCars(boolean includeAll) {
        List<Car> cars = carRepository.findAll();
        List<CarResponse> response = new ArrayList<>();
        for (Car car : cars) {
            CarResponse cr = new CarResponse(car, includeAll);
            response.add(cr);
        }
        return response;
    }

    public void deleteCarById(Long id) {
        Car carToDelete = carRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.BAD_REQUEST, "Car not found"));

        carRepository.delete(carToDelete);
    }

    public CarResponse addCar(CarRequest body) {
        if (carRepository.existsById(body.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user already exists");
        }
        Car newCar = CarRequest.getCarEntity(body);

        newCar = carRepository.save(newCar);
        return new CarResponse(newCar, true);
    }

    public ResponseEntity<Boolean> editCar(CarRequest body, Long id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this id does not exist"));
        if (!body.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot change id");
        }

        car.setBrand(body.getBrand());
        car.setModel(body.getModel());
        car.setPricePerDay(body.getPricePerDay());
        car.setBestDiscount(body.getBestDiscount());
        carRepository.save(car);

        return ResponseEntity.ok(true);
    }

    public CarResponse findById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this id does exist"));
        return new CarResponse(car, true);
    }

    public void setDiscountForCar(Long id, int value) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this id does exist"));
        car.setBestDiscount(value);
        carRepository.save(car);
    }

    public void setRentalPriceForCar(Long id, int value) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this id does exist"));
        car.setBestDiscount(value);
        carRepository.save(car);
    }

    public List<CarResponse> findCarsByBrandAndModel(String brand, String model) {
        List<Car> cars = carRepository.findAllByBrandAndModel(brand, model);
        List<CarResponse> response = new ArrayList<>();
        for (Car car : cars) {
            CarResponse cr = new CarResponse(car, true);
            response.add(cr);
        }
        return response;
    }

    public List<CarResponse> getAllCarsOrderByMaxDiscountDesc() {
        List<Car> cars = carRepository.findAllOrderByMaxDiscountDesc();
        List<CarResponse> carResponses = new ArrayList<>();

        for (Car car : cars) {
            CarResponse carResponse = new CarResponse();
            carResponse.setModel(car.getModel());
            carResponse.setBrand(car.getBrand());
            carResponse.setPricePerDay(car.getPricePerDay());
            carResponse.setBestDiscount(car.getBestDiscount());

            carResponses.add(carResponse);
        }
        return carResponses;
    }

    public Double getAverageRentalPricePerDay() {
        return carRepository.findAverageRentalPricePerDay();
    }
}
