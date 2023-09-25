package dat3.car.cars.api;

import dat3.car.cars.dto.ReservationRequest;
import dat3.car.cars.dto.ReservationResponse;
import dat3.car.cars.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/reservations")
public class ReservationController {

    // Constructor Injection
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    ReservationResponse makeReservation(@RequestBody ReservationRequest res){
        ReservationResponse r = reservationService.reserveCar(res);
        return r;
    }

    //ADMIN
    @GetMapping
    public List<ReservationResponse> getReservations(){
        List<ReservationResponse> res = reservationService.getReservations();
        return res;
    }

    //USER (the current USER)
    @GetMapping("/reservations-for-authenticated")
    public List<ReservationResponse> getReservationsForUser(Principal principal){
        List<ReservationResponse> res = reservationService.getReservationsForUser(principal.getName());
        return res;
    }

    //ADMIN
    @GetMapping("/{userName}")
    public List<ReservationResponse> getReservationsForUser(@PathVariable String userName){
        List<ReservationResponse> res = reservationService.getReservationsForUser(userName);
        return res;
    }
}
