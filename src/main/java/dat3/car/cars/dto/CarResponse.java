package dat3.car.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.cars.entity.Car;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

    // Attributes
    private Long id;
    private String brand;
    private String model;
    private double pricePerDay;
    private Integer bestDiscount;
    private LocalDateTime created;

    // Date Format
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime edited;

    // Convert Car Entity to Car DTO
    public CarResponse(Car c, boolean includeAll) {
        this.brand = c.getBrand();
        this.model = c.getModel();
        this.pricePerDay = c.getPricePerDay();
        if (includeAll) {
            this.id = c.getId();
            this.bestDiscount = c.getBestDiscount();
            this.created = c.getCreated();
            this.edited = c.getEdited();
        }
    }
}
