package dat3.car.cars.api;

import dat3.car.cars.dto.CarRequest;
import dat3.car.cars.dto.CarResponse;
import dat3.car.cars.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    // Constructor Injection
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Controller Methods

    // Security Admin
    @GetMapping
    List<CarResponse> getCars() {
        return carService.getCars(false);
    }

    // Security Admin
    @DeleteMapping("/{id}")
    void deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
    }

    // Security Anonymous
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CarResponse addCar(@RequestBody CarRequest body) {
        return carService.addCar(body);
    }

    // Security Admin
    @PutMapping("/{id}")
    ResponseEntity<Boolean> editMember(@RequestBody CarRequest body, @PathVariable Long id) {
        return carService.editCar(body, id);
    }

    // Security Admin
    @GetMapping(path = "/{id}")
    CarResponse getCarById(@PathVariable Long id) {
        return carService.findById(id);
    }

    // Security Admin
    @PatchMapping("/discount/{id}/{value}")
    void setDiscountForCar(@PathVariable Long id, @PathVariable int value) {
        carService.setDiscountForCar(id, value);
    }

    // Security Admin
    @PatchMapping("/rental/{id}/{value}")
    void setRentalPriceForCar(@PathVariable Long id, @PathVariable int value) {
        carService.setRentalPriceForCar(id, value);
    }

    @GetMapping("/find/{brand}/{model}")
    public List<CarResponse> findCarsByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        return carService.findCarsByBrandAndModel(brand, model);
    }

    @GetMapping("/sortedByBestDiscount")
    public List<CarResponse> sortCarsByBestDiscount() {
        return carService.getAllCarsOrderByMaxDiscountDesc();
    }

    @GetMapping("/averageRentalPrice")
    public Double getAverageRentalPricePerDay() {
        return carService.getAverageRentalPricePerDay();
    }
}
