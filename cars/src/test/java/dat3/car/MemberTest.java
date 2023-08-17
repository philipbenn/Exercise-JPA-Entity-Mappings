package dat3.car;

import dat3.car.cars.entity.Member;
import dat3.car.cars.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

     @Test
    public void testSaveAndFindMember() {
        Member member = new Member("johnnytest", "johnnypassword123", "johnnytest@gmail.com",
                "Johnny", "Test", "123 Street", "New York", "12345");
        memberRepository.save(member);

        Member foundMember = memberRepository.findById("johnnytest").orElse(null);

        assertNotNull(foundMember);
        assertEquals("Johnny", foundMember.getFirstName());
    }

    @Test
    public void testCountMembers() {
        Member member1 = new Member("Hans312", "Hansersej321", "hans@gmail.com",
                "Hans", "Hansen", "Guldbergsgade 32", "Copenhagen", "12345");
        Member member2 = new Member("Per", "persword", "postmandper@gmail.com",
                "Per", "Petersen", "Noerrebrogade", "Copenhagen", "67890");

        memberRepository.save(member1);
        memberRepository.save(member2);

        long memberCount = memberRepository.count();

        assertEquals(2, memberCount);
    }
}
