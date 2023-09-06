package dat3.car.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.car.cars.entity.Car;
import dat3.car.cars.entity.Member;
import dat3.car.cars.entity.Reservation;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationRequest {

    // Attributes
    int carId;
    String userName;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    LocalDate date;
}
