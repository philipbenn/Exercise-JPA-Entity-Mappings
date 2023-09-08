package dat3.car.cars.service;

import dat3.car.cars.dto.ReservationRequest;
import dat3.car.cars.dto.ReservationResponse;
import dat3.car.cars.entity.Car;
import dat3.car.cars.entity.Member;
import dat3.car.cars.entity.Reservation;
import dat3.car.cars.repository.CarRepository;
import dat3.car.cars.repository.MemberRepository;
import dat3.car.cars.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class ReservationService {

    // Constructor Injection
    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final CarRepository carRepository;

    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }

    public ReservationResponse reserveCar(ReservationRequest body) {
        // Checks if reservation date is before current date
        if (body.getDate().isBefore(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please choose a valid date");
        }
        Member member = memberRepository.findById(body.getUserName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No member with this id found"));
        Car car = carRepository.findById(body.getCarId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No car with this id found"));

        // Checks if car is already reserved on date
        if (reservationRepository.existsByCar_IdAndRentalDate(body.getCarId(), body.getDate())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This car is reserved on given date");
        }

        Reservation res = reservationRepository.save(new Reservation(car, member, body.getDate()));
        return new ReservationResponse(res);
    }
}
