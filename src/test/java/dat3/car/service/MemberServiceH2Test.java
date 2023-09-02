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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberServiceH2Test {

    @Autowired
    MemberRepository memberRepository;

    MemberService memberService;

    Member m1, m2;

    @BeforeEach
    void setUp() {
        memberService = new MemberService(memberRepository);
        Member m1 = new Member("user1", "pw1", "fn1", "ln1", "email1", "street1", "city1", "zip1");
        Member m2 = new Member("user2", "pw2", "fn2", "ln2", "email2", "street2", "city2", "zip2");
        memberRepository.save(m1);
        memberRepository.save(m2);
    }

    @Test
    void testGetMembersAllDetails() {
        List<MemberResponse> allDetailsMembers = memberService.getMembers(true);

        for (MemberResponse member : allDetailsMembers) {
            assertNotNull(member.getUsername());
            assertNotNull(member.getEmail());
            assertNotNull(member.getFirstName());
            assertNotNull(member.getLastName());
            assertNotNull(member.getStreet());
            assertNotNull(member.getCity());
            assertNotNull(member.getZip());
            assertNotNull(member.getCreated());
            assertNotNull(member.getEdited());
            assertNotNull(member.getRanking());
            assertNotNull(member.getApproved());
        }
    }

    @Test
    void testGetMembersNoDetails() {
        List<MemberResponse> noDetailMembers = memberService.getMembers(false);

        for (MemberResponse member : noDetailMembers) {
            assertNull(member.getCreated());
            assertNull(member.getEdited());
            assertNull(member.getRanking());
            assertNull(member.getApproved());
        }
    }

    @Test
    void testFindByIdFound() {
        MemberResponse response = memberService.findById("user1");
        assertEquals("user1", response.getUsername());
    }

    @Test
    void testFindByIdNotFound() {
        String nonExistentUsername = "nonExistentUser";
        assertThrows(ResponseStatusException.class, () -> {
            memberService.findById(nonExistentUsername);
        });
    }

    @Test
    void testAddMember_UserDoesNotExist() {
        Member member = new Member("sejephilip", "Password098", "philip@gmail.com", "Philip", "Philipsen",
                "philipsgade 1", "Copenhagen", "zip");
        MemberRequest memberRequest = new MemberRequest(member);
        memberService.addMember(memberRequest);

        assertEquals("Philip", member.getFirstName(), "Firstname expected");
    }

    @Test
    void testEditMemberWithExistingUsername() {

    }

    @Test
    void testEditMemberNON_ExistingUsernameThrows() {

    }

    @Test
    void testEditMemberChangePrimaryKeyThrows() {

    }

    @Test
    void testSetRankingForUser() {
        memberService.setRankingForUser("user1", 10);
        assertEquals(10, memberService.getMemberByUsername("user1").getRanking());
    }

    @Test
    void testSetRankingForNoExistingUser() {
        assertThrows(ResponseStatusException.class, () -> memberService.getMemberByUsername("user3").setRanking(10));
    }

    @Test
    void testDeleteMemberByUsername() {
        memberService.deleteMemberByUsername("user1");
        assertThrows(ResponseStatusException.class, () -> memberService.findById("user1"));
    }
}

