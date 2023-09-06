package dat3.car.service;

import dat3.car.cars.entity.Car;
import dat3.car.cars.entity.Member;
import dat3.car.cars.entity.Reservation;
import dat3.car.cars.repository.CarRepository;
import dat3.car.cars.repository.MemberRepository;
import dat3.car.cars.repository.ReservationRepository;
import dat3.car.cars.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ReservationServiceH2Test {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CarRepository carRepository;

    ReservationService reservationService;

    Reservation r1, r2;
    Car c1, c2;
    Member m1, m2;

    LocalDate localDate = LocalDate.now();

    @BeforeEach
    void setUp() {
        reservationService = new ReservationService(reservationRepository, memberRepository, carRepository);
        Member m1 = new Member("user1", "pw1", "fn1", "ln1", "email1", "street1", "city1", "zip1");
        Member m2 = new Member("user2", "pw2", "fn2", "ln2", "email2", "street2", "city2", "zip2");

        Car c1 = new Car("Audi", "RS6", 70, 10);
        Car c2 = new Car("Peugeot", "107", 20, 25);

        Reservation r1 = new Reservation(c1, m1, localDate.plusWeeks(1));
        Reservation r2 = new Reservation(c2, m2, localDate.plusDays(2));

        memberRepository.save(m1);
        memberRepository.save(m2);
        carRepository.save(c1);
        carRepository.save(c2);
        reservationRepository.save(r1);
        reservationRepository.save(r2);
    }

    @Test
    void testCheckIfDateIsInThePast() {
        LocalDate reservationDate = LocalDate.now().plusDays(1);
        assertFalse(reservationDate.isBefore(LocalDate.now()));
    }
}
