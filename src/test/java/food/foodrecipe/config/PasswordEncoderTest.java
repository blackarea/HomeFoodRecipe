package food.foodrecipe.config;

import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.Role;
import food.foodrecipe.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PasswordEncoderTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    PasswordEncoder encoder;

    @Test
    public void testInsert(){
        Member member = Member.builder()
                .user_id("user")
                .password(encoder.encode("pwd"))
                .name("name")
                .role(Role.ROLE_MEMBER)
                .build();
        memberRepository.save(member);
    }
}