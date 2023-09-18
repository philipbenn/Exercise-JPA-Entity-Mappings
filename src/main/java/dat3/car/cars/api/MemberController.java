package dat3.car.cars.api;

import dat3.car.cars.dto.MemberRequest;
import dat3.car.cars.dto.MemberResponse;
import dat3.car.cars.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/members")
class MemberController {

    // Constructor Injection
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Controller Methods

    // Security Admin only
    @GetMapping
    List<MemberResponse> getMembers() {
        return memberService.getMembers(false);
    }

    // Security Admin only
    @GetMapping(path = "/{username}")
    MemberResponse getMemberById(@PathVariable String username) {
        return memberService.findById(username);
    }

    // Security --> Anonymous
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MemberResponse addMember(@RequestBody MemberRequest body) {
        return memberService.addMember(body);
    }

    // Security Admin
    @PutMapping("/{username}")
    void editMember(@RequestBody MemberRequest body, @PathVariable String username) {
        memberService.editMember(body, username);
    }

    // Security Admin
    @PatchMapping("/ranking/{username}/{value}")
    void setRankingForUser(@PathVariable String username, @PathVariable int value) {
        memberService.setRankingForUser(username, value);
    }

    // Security Admin
    @DeleteMapping("/{username}")
    void deleteMemberByUsername(@PathVariable String username) {
        memberService.deleteMemberByUsername(username);
    }

    @GetMapping("/reservations")
    List<MemberResponse> getMembersWithReservations() {
        return memberService.findAllMembersWithReservations();
    }
}



