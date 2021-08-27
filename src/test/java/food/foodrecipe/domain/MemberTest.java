package food.foodrecipe.domain;

import food.foodrecipe.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void save(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Member member = Member.builder()
                    .user_id("user" + i)
                    .password("pwd"+ i)
                    .name("name" +i)
                    .build();
            memberRepository.save(member);
        });

        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            System.out.println("member = " + member);
        }
    }

}