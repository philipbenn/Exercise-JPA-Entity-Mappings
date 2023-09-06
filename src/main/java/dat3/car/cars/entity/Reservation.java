package dat3.car.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Reservation {

    // Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relations
    @ManyToOne
    private Car car;

    @ManyToOne
    private Member member;

    // Columns
    @Column(name = "rental_date")
    private LocalDate rentalDate;

    // Constructor
    public Reservation(Car car, Member member, LocalDate rentalDate) {
        this.car = car;
        this.member = member;
        this.rentalDate = rentalDate;
        car.addReservation(this);
        member.addReservation(this);
    }
}
