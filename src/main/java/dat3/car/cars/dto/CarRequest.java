package dat3.car.cars.dto;

import dat3.car.cars.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarRequest {

    // Attributes
    private Long id;
    private String brand;
    private String model;
    private double pricePerDay;
    private int bestDiscount;

    // Static method
    public static Car getCarEntity(CarRequest c) {
        return new Car(c.getBrand(), c.getModel(), c.getPricePerDay(), c.getBestDiscount());
    }

    // Constructor
    // Car to CarRequest conversion
    public CarRequest(Car m) {
        this.id = m.getId();
        this.brand = m.getBrand();
        this.model = m.getModel();
        this.pricePerDay = m.getPricePerDay();
        this.bestDiscount = m.getBestDiscount();
    }
}
