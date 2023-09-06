package dat3.car.cars.config;

import dat3.car.cars.entity.Car;
import dat3.car.cars.entity.Member;
import dat3.car.cars.entity.Reservation;
import dat3.car.cars.repository.CarRepository;
import dat3.car.cars.repository.MemberRepository;
import dat3.car.cars.repository.ReservationRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {

    // Constructor Injections
    private final CarRepository carRepository;
    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;

    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
         // createCars();
         // createMembers();
         // createReservations();
    }

    // Method that initiates members (Made By ChatGPT)
    public void createMembers() {
        List<Member> members = new ArrayList<>();
        members.add(new Member("john_doe", "password123", "john@example.com", "John", "Doe", "123 Main St", "Springfield", "12345"));
        members.add(new Member("jane_smith", "securepass", "jane@example.com", "Jane", "Smith", "456 Elm St", "Riverside", "67890"));
        members.add(new Member("alex_johnson", "myp@ssw0rd", "alex@example.com", "Alex", "Johnson", "789 Oak Ave", "Pleasantville", "54321"));
        members.add(new Member("emily_brown", "pass1234", "emily@example.com", "Emily", "Brown", "234 Pine Rd", "Hometown", "98765"));
        members.add(new Member("michael_wilson", "ilovecoding", "michael@example.com", "Michael", "Wilson", "567 Cedar Ln", "Techville", "13579"));
        members.add(new Member("olivia_jackson", "pa$$w0rd", "olivia@example.com", "Olivia", "Jackson", "890 Birch Blvd", "Metroville", "24680"));
        members.add(new Member("william_thomas", "thomaspass", "william@example.com", "William", "Thomas", "345 Maple Dr", "Suburbia", "97531"));
        members.add(new Member("sophia_johnson", "p@ssw0rd", "sophia@example.com", "Sophia", "Johnson", "678 Walnut St", "Townsville", "86420"));
        members.add(new Member("jacob_miller", "passw0rd", "jacob@example.com", "Jacob", "Miller", "901 Pineapple Ave", "Seaside", "15963"));
        members.add(new Member("ava_anderson", "mypassword", "ava@example.com", "Ava", "Anderson", "1234 Palm Rd", "Coastal City", "35724"));

        memberRepository.saveAll(members);
    }

    // Method that initiates cars (Made By ChatGPT)
    public void createCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Corolla", 60.0, 10));
        cars.add(new Car("Honda", "Civic", 65.0, 15));
        cars.add(new Car("Ford", "Mustang", 100.0, 20));
        cars.add(new Car("Chevrolet", "Cruze", 55.0, 12));
        cars.add(new Car("Volkswagen", "Golf", 70.0, 18));
        cars.add(new Car("BMW", "3 Series", 90.0, 25));
        cars.add(new Car("Mercedes-Benz", "C-Class", 95.0, 22));
        cars.add(new Car("Audi", "A4", 85.0, 20));
        cars.add(new Car("Nissan", "Altima", 55.0, 10));
        cars.add(new Car("Hyundai", "Elantra", 50.0, 8));
        cars.add(new Car("Kia", "Optima", 52.0, 9));
        cars.add(new Car("Mazda", "3", 58.0, 11));
        cars.add(new Car("Subaru", "Impreza", 56.0, 10));
        cars.add(new Car("Jeep", "Wrangler", 110.0, 30));
        cars.add(new Car("Tesla", "Model 3", 120.0, 25));
        cars.add(new Car("Volvo", "S60", 75.0, 18));
        cars.add(new Car("Porsche", "911", 200.0, 35));
        cars.add(new Car("Lexus", "RX", 95.0, 20));
        cars.add(new Car("Infiniti", "Q50", 80.0, 15));
        cars.add(new Car("GMC", "Sierra", 90.0, 22));
        cars.add(new Car("Ferrari", "488", 300.0, 40));
        cars.add(new Car("Maserati", "Ghibli", 220.0, 30));
        cars.add(new Car("Jaguar", "F-Type", 180.0, 25));
        cars.add(new Car("Lamborghini", "Huracan", 400.0, 45));
        cars.add(new Car("Aston Martin", "DB11", 250.0, 30));
        cars.add(new Car("Rolls-Royce", "Phantom", 500.0, 50));
        cars.add(new Car("Bugatti", "Chiron", 1000.0, 60));
        cars.add(new Car("McLaren", "720S", 300.0, 40));
        cars.add(new Car("Fiat", "500", 45.0, 5));
        cars.add(new Car("Alfa Romeo", "Giulia", 70.0, 10));
        cars.add(new Car("Mini", "Cooper", 55.0, 8));
        cars.add(new Car("Land Rover", "Range Rover", 150.0, 20));
        cars.add(new Car("Bentley", "Continental", 280.0, 30));
        cars.add(new Car("Porsche", "Cayenne", 170.0, 15));
        cars.add(new Car("Acura", "MDX", 90.0, 12));
        cars.add(new Car("Cadillac", "Escalade", 120.0, 15));
        cars.add(new Car("Lincoln", "Navigator", 130.0, 18));
        cars.add(new Car("Chrysler", "300", 75.0, 10));
        cars.add(new Car("Buick", "Enclave", 80.0, 8));
        cars.add(new Car("Dodge", "Charger", 85.0, 12));
        cars.add(new Car("Jeep", "Grand Cherokee", 110.0, 18));
        cars.add(new Car("RAM", "1500", 95.0, 10));
        cars.add(new Car("Chevrolet", "Silverado", 100.0, 12));
        cars.add(new Car("GMC", "Yukon", 130.0, 15));
        cars.add(new Car("Toyota", "Rav4", 70.0, 10));
        cars.add(new Car("Nissan", "Rogue", 65.0, 8));
        cars.add(new Car("Ford", "Escape", 75.0, 10));
        cars.add(new Car("Honda", "CR-V", 72.0, 9));
        cars.add(new Car("Mazda", "CX-5", 68.0, 8));
        cars.add(new Car("Subaru", "Outback", 70.0, 9));

        carRepository.saveAll(cars);
    }

    // Da jeg har lagt mine lister ud i metoder, har jeg valgt at instantiere et par nye biler og members, så jeg
    // har nogle biler og members at binde reservationer på.
    public void createReservations() {
        List<Reservation> reservations = new ArrayList<>();
        List<Car> tempCarList = new ArrayList<>();
        List<Member> tempMemberList = new ArrayList<>();
        Car car1 = new Car("Audi", "RS6", 70, 10);
        Member member1 = new Member("hans_hansen", "hemmeligt", "hans@gmail.com", "Hans", "Hansen", "Hansenvej 12", "Odense", "1234");
        Car car2 = new Car("Peugeot", "107", 20, 25);
        Member member2 = new Member("ole_olesen", "hemmeligt123", "ole@gmail.com", "Ole", "Olesen", "Olesen 12", "Odense", "5432");
        Car car3 = new Car("Bmw", "M3", 90, 15);
        Member member3 = new Member("john_johnsen", "hemmeligt456", "john@gmail.com", "John", "Johnsen", "Johnsenvej 12", "Odense", "8653");
        LocalDate time = LocalDate.now();

        tempCarList.add(car1);
        tempCarList.add(car2);
        tempCarList.add(car3);
        tempMemberList.add(member1);
        tempMemberList.add(member2);
        tempMemberList.add(member3);

        reservations.add(new Reservation(car1, member1, time));
        reservations.add(new Reservation(car2, member2, time.plusWeeks(1)));
        reservations.add(new Reservation(car3, member3, time.plusMonths(1)));

        carRepository.saveAll(tempCarList);
        memberRepository.saveAll(tempMemberList);
        reservationRepository.saveAll(reservations);
    }
}
