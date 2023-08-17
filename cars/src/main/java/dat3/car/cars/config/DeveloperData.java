package dat3.car.cars.config;

import dat3.car.cars.entity.Car;
import dat3.car.cars.entity.Member;
import dat3.car.cars.repository.CarRepository;
import dat3.car.cars.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

@Controller
public class DeveloperData implements ApplicationRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) {
        createCars();
        createMembers();
    }

    public void createMembers() {
        Member member1 = new Member("john_doe", "password123", "john@example.com", "John", "Doe", "123 Main St", "Springfield", "12345");
        Member member2 = new Member("jane_smith", "securepass", "jane@example.com", "Jane", "Smith", "456 Elm St", "Riverside", "67890");
        Member member3 = new Member("alex_johnson", "myp@ssw0rd", "alex@example.com", "Alex", "Johnson", "789 Oak Ave", "Pleasantville", "54321");
        Member member4 = new Member("emily_brown", "pass1234", "emily@example.com", "Emily", "Brown", "234 Pine Rd", "Hometown", "98765");
        Member member5 = new Member("michael_wilson", "ilovecoding", "michael@example.com", "Michael", "Wilson", "567 Cedar Ln", "Techville", "13579");
        Member member6 = new Member("olivia_jackson", "pa$$w0rd", "olivia@example.com", "Olivia", "Jackson", "890 Birch Blvd", "Metroville", "24680");
        Member member7 = new Member("william_thomas", "thomaspass", "william@example.com", "William", "Thomas", "345 Maple Dr", "Suburbia", "97531");
        Member member8 = new Member("sophia_johnson", "p@ssw0rd", "sophia@example.com", "Sophia", "Johnson", "678 Walnut St", "Townsville", "86420");
        Member member9 = new Member("jacob_miller", "passw0rd", "jacob@example.com", "Jacob", "Miller", "901 Pineapple Ave", "Seaside", "15963");
        Member member10 = new Member("ava_anderson", "mypassword", "ava@example.com", "Ava", "Anderson", "1234 Palm Rd", "Coastal City", "35724");

        memberRepository.saveAll(Arrays.asList(member1, member2, member3, member4, member5, member6, member7, member8, member9,
                member10));
    }

    public void createCars() {
        Car car1 = new Car("Toyota", "Corolla", 60.0, 10);
        Car car2 = new Car("Honda", "Civic", 65.0, 15);
        Car car3 = new Car("Ford", "Mustang", 100.0, 20);
        Car car4 = new Car("Chevrolet", "Cruze", 55.0, 12);
        Car car5 = new Car("Volkswagen", "Golf", 70.0, 18);
        Car car6 = new Car("BMW", "3 Series", 90.0, 25);
        Car car7 = new Car("Mercedes-Benz", "C-Class", 95.0, 22);
        Car car8 = new Car("Audi", "A4", 85.0, 20);
        Car car9 = new Car("Nissan", "Altima", 55.0, 10);
        Car car10 = new Car("Hyundai", "Elantra", 50.0, 8);
        Car car11 = new Car("Kia", "Optima", 52.0, 9);
        Car car12 = new Car("Mazda", "3", 58.0, 11);
        Car car13 = new Car("Subaru", "Impreza", 56.0, 10);
        Car car14 = new Car("Jeep", "Wrangler", 110.0, 30);
        Car car15 = new Car("Tesla", "Model 3", 120.0, 25);
        Car car16 = new Car("Volvo", "S60", 75.0, 18);
        Car car17 = new Car("Porsche", "911", 200.0, 35);
        Car car18 = new Car("Lexus", "RX", 95.0, 20);
        Car car19 = new Car("Infiniti", "Q50", 80.0, 15);
        Car car20 = new Car("GMC", "Sierra", 90.0, 22);
        Car car21 = new Car("Ferrari", "488", 300.0, 40);
        Car car22 = new Car("Maserati", "Ghibli", 220.0, 30);
        Car car23 = new Car("Jaguar", "F-Type", 180.0, 25);
        Car car24 = new Car("Lamborghini", "Huracan", 400.0, 45);
        Car car25 = new Car("Aston Martin", "DB11", 250.0, 30);
        Car car26 = new Car("Rolls-Royce", "Phantom", 500.0, 50);
        Car car27 = new Car("Bugatti", "Chiron", 1000.0, 60);
        Car car28 = new Car("McLaren", "720S", 300.0, 40);
        Car car29 = new Car("Fiat", "500", 45.0, 5);
        Car car30 = new Car("Alfa Romeo", "Giulia", 70.0, 10);
        Car car31 = new Car("Mini", "Cooper", 55.0, 8);
        Car car32 = new Car("Land Rover", "Range Rover", 150.0, 20);
        Car car33 = new Car("Bentley", "Continental", 280.0, 30);
        Car car34 = new Car("Porsche", "Cayenne", 170.0, 15);
        Car car35 = new Car("Acura", "MDX", 90.0, 12);
        Car car36 = new Car("Cadillac", "Escalade", 120.0, 15);
        Car car37 = new Car("Lincoln", "Navigator", 130.0, 18);
        Car car38 = new Car("Chrysler", "300", 75.0, 10);
        Car car39 = new Car("Buick", "Enclave", 80.0, 8);
        Car car40 = new Car("Dodge", "Charger", 85.0, 12);
        Car car41 = new Car("Jeep", "Grand Cherokee", 110.0, 18);
        Car car42 = new Car("RAM", "1500", 95.0, 10);
        Car car43 = new Car("Chevrolet", "Silverado", 100.0, 12);
        Car car44 = new Car("GMC", "Yukon", 130.0, 15);
        Car car45 = new Car("Toyota", "Rav4", 70.0, 10);
        Car car46 = new Car("Nissan", "Rogue", 65.0, 8);
        Car car47 = new Car("Ford", "Escape", 75.0, 10);
        Car car48 = new Car("Honda", "CR-V", 72.0, 9);
        Car car49 = new Car("Mazda", "CX-5", 68.0, 8);
        Car car50 = new Car("Subaru", "Outback", 70.0, 9);

        carRepository.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13, car14,
                car15, car16, car17, car18, car19, car20, car21, car22, car23, car24, car25, car26, car27, car28, car29, car30, car31,
                car32, car33, car34, car35, car36, car37, car38, car39, car40, car41, car42, car43, car44, car45, car46, car47, car48,
                car49, car50));
    }
}
