package dat3.car.cars.api;

import dat3.car.cars.dto.ReservationRequest;
import dat3.car.cars.dto.ReservationResponse;
import dat3.car.cars.service.ReservationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    // Constructor Injection
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping()
    public ReservationResponse makeReservation(@RequestBody ReservationRequest request) {
        return reservationService.reserveCar(request);
    }
}
