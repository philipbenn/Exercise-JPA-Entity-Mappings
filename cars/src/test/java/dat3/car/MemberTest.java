package dat3.car;

import dat3.car.cars.entity.Member;
import dat3.car.cars.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

   

}
