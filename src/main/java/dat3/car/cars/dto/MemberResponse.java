package dat3.car.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.cars.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponse {

    // Attributes
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private LocalDateTime created;

    // Date Format
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime edited;

    // Integer & Boolean to achieve null values
    private Integer ranking;
    private Boolean approved;

    // Convert Member Entity to Member DTO
    public MemberResponse(Member m, boolean includeAll) {
        this.username = m.getUsername();
        this.email = m.getEmail();
        this.street = m.getStreet();
        this.firstName = m.getFirstName();
        this.lastName = m.getLastName();
        this.city = m.getCity();
        this.zip = m.getZip();
        if (includeAll) {
            this.created = m.getCreated();
            this.edited = m.getEdited();
            this.approved = m.isApproved();
            this.ranking = m.getRanking();
        }
    }
}


