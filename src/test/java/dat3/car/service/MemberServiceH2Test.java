package dat3.car.service;

import dat3.car.cars.dto.MemberRequest;
import dat3.car.cars.dto.MemberResponse;
import dat3.car.cars.entity.Member;
import dat3.car.cars.repository.MemberRepository;
import dat3.car.cars.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
class MemberServiceH2Test {

    @Autowired
    MemberRepository memberRepository;
    MemberService memberService;

    Member m1, m2;  //Talk about references in Java for why we don't add the "isInitialize flag"

    @BeforeEach
    void setUp() {
        memberService = new MemberService(memberRepository); //Set up memberService with the mock (H2) database
    }

    private Member makeMember(String username, String password, String firstName, String lastName, String email, String street, String city, String zip) {
        Member member = new Member(username, password, firstName, lastName, email, street, city, zip);
        member.setCreated(LocalDateTime.now());
        member.setEdited(LocalDateTime.now());
        return member;
    }

    private Member makeMember2() {
        Member m2 = new Member("user2", "pw2", "fn2", "ln2", "email2", "street2", "city2", "zip2");
        m2.setCreated(LocalDateTime.now());
        m2.setEdited(LocalDateTime.now());
        return m2;
    }


    @Test
    void testGetMembersAllDetails() {
        List<MemberResponse> memberResponses = memberService.getMembers(true);
        assertEquals(2, memberResponses.size(), "Expects 2 members");
        LocalDateTime time = memberResponses.get(0).getCreated();
        assertNotNull(time, "Expects date to be set");
    }

    @Test
    void testGetMembersNoDetails() {
        List<MemberResponse> memberResponses = memberService.getMembers(false);
        assertEquals(2, memberResponses.size(), "Expects 2 members");
        LocalDateTime time = memberResponses.get(0).getCreated();
        assertNull(time, "Expects date NOT to be set");
    }

    @Test
    void testFindByIdFound() {
        MemberResponse response = memberService.findById(m1.getUsername());
        assertEquals(m1.getUsername(), response.getUsername());
    }

    @Test
    void testFindByIdNotFound() {
        assertThrows(ResolutionException.class, () -> memberService.findById("I dont exist"));

    }

    @Test
        /* Remember MemberRequest comes from the API layer, and MemberResponse is returned to the API layer
         * Internally addMember savex a Member entity to the database*/
    void testAddMember_UserDoesNotExist() {
        //Add @AllArgsConstructor to MemberRequest and @Builder to MemberRequest for this to work
        //TODO
    }

    @Test
    public void testAddMember_UserExists() {
        when(memberRepository.existsById("user1")).thenReturn(true);
        assertThrows(ResponseStatusException.class, () -> {
            Member existingMember = makeMember("user1", "pw1", "fn1", "ln1", "email1", "street1", "city1", "zip1");
            //Make a MemberRequest with a username that already exists
            MemberRequest mr = new MemberRequest(existingMember);
            memberService.addMember(mr);
        });
    }

    @Test
    void testEditMemberWithExistingUsername() {
        //TODO
    }

    @Test
    void testEditMemberNON_ExistingUsernameThrows() {
        //This should test that a ResponseStatus exception is thrown with status= 404 (NOT_FOUND)
        //TODO
    }

    @Test
    void testEditMemberChangePrimaryKeyThrows() {
        //Create a MemberRequest from an existing member we can edit
        MemberRequest request = new MemberRequest(m1);
        //TODO
    }

    @Test
    public void testSetRankingForUser_MemberFound() {
        Member m1 = new Member();
        m1.setUsername("user1");
        when(memberRepository.findById("user1")).thenReturn(Optional.of(m1));
        int testRanking = 5;

        // Mock the behavior of memberRepository to save the testMember.
        when(memberRepository.save(m1)).thenReturn(m1);
        memberService.setRankingForUser("user1", testRanking);
        assertEquals(testRanking, m1.getRanking());

        // Verify that memberRepository's save method was called with the testMember.
        verify(memberRepository).save(m1);
    }

    @Test
    public void testSetRankingForUser_MemberNotFound() {
        String testUsername = "testUser";
        // Mock the behavior of memberRepository to return an empty Optional when findById is called with testUsername.
        when(memberRepository.findById(testUsername)).thenReturn(Optional.empty());
        // Assert that the method throws a ResponseStatusException with a BAD_REQUEST status.
        assertThrows(ResponseStatusException.class, () -> memberService.setRankingForUser(testUsername, 5));
    }

    @Test
    public void testDeleteMemberByUsername() {
        String testUsername = "testUser";
        Member testMember = new Member();
        testMember.setUsername(testUsername);

        // Mock the behavior of memberRepository to return the testMember when findById is called with testUsername.
        when(memberRepository.findById(testUsername)).thenReturn(Optional.of(testMember));

        // Call the method under test.
        memberService.deleteMemberByUsername(testUsername);

        // Verify that memberRepository's delete method was called with the testMember.
        verify(memberRepository).delete(testMember);
    }

    @Test
    public void testDeleteMemberByUsername_MemberNotFound() {
        String testUsername = "testUser";

        // Mock the behavior of memberRepository to return an empty Optional when findById is called with testUsername.
        when(memberRepository.findById(testUsername)).thenReturn(Optional.empty());

        // Assert that the method throws a ResponseStatusException with a BAD_REQUEST status.
        assertThrows(ResponseStatusException.class, () -> memberService.deleteMemberByUsername(testUsername));
    }
}

