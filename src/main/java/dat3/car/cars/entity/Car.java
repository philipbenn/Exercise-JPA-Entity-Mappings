package dat3.car.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "cars")
public class Car extends AdminDetails {

    // Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Columns
    @Column(name = "car_brand", nullable = false, length = 50)
    private String brand;
    @Column(name = "car_model", nullable = false, length = 60)
    private String model;
    @Column(name = "rental_price_day")
    private double pricePerDay;
    @Column(name = "max_discount")
    private int bestDiscount;

    // Constructors
    public Car(String brand, String model, double pricePerDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.bestDiscount = bestDiscount;
    }
}