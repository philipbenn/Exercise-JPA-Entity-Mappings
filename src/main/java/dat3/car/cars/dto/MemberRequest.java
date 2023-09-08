package dat3.car.cars.dto;

import dat3.car.cars.entity.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MemberRequest {

    // Attributes
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;

    // Static method
    public static Member getMemberEntity(MemberRequest m) {
        return new Member(m.username, m.getPassword(), m.getEmail(), m.firstName, m.lastName, m.getStreet(), m.getCity(), m.getZip());
    }

    // Constructor
    // Member to MemberRequest conversion
    public MemberRequest(Member m) {
        this.username = m.getUsername();
        this.password = m.getPassword();
        this.email = m.getEmail();
        this.street = m.getStreet();
        this.city = m.getCity();
        this.zip = m.getZip();
    }
}

