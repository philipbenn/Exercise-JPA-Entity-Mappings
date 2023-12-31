package dat3.car.cars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.cars.entity.Reservation;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {

    // Attributes
    private Long id;
    private Long carId;
    private double price;
    private String brand;
    private String model;
    private LocalDate reservationDate;

    // Constructor
    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.carId = reservation.getCar().getId();
        this.price = reservation.getCar().getPricePerDay();
        this.brand = reservation.getCar().getBrand();
        this.model = reservation.getCar().getModel();
        this.reservationDate = reservation.getRentalDate();
    }
}
