package food.foodrecipe.service;

import food.foodrecipe.domain.form.MemberForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired private MemberService memberService;

    @Test
    public void saveTest(){
        MemberForm memberForm = new MemberForm();
        memberForm.setUser_id("id");
        memberForm.setPassword("pwd");
        memberForm.setUsername("name");
        memberService.save(memberForm);


    }
}