package dat3.car.cars.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "members")
public class Member extends AdminDetails {

    // Id
    @Id
    private String username;

    // Columns
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private boolean approved;
    private int ranking;

    // Constructors
    public Member(String user, String password, String email, String firstName,
                  String lastName, String street, String city, String zip) {
        this.username = user;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}
