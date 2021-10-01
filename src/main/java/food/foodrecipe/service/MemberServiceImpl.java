package food.foodrecipe.service;

import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.form.MemberForm;
import food.foodrecipe.domain.Recipe;
import food.foodrecipe.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    //name, pwd, 등등 바꾸기
    //설정 등 멤버 관리

    @Autowired private MemberRepository memberRepository;
    //@Autowired private PasswordEncoder passwordEncoder;

    @Override
    public Member save(MemberForm memberForm) {
        //String encodedPassword = passwordEncoder.encode(memberForm.getPassword());
        Member member = new Member(memberForm.getUser_id(), memberForm.getPassword(), memberForm.getUsername());
        return memberRepository.save(member);
    }

    @Override
    public List<Recipe> getMyRecipeList(Member member) {
        Member findMember = memberRepository.findById(member.getId()).get();
        List<Recipe> recipes = findMember.getRecipes();
        return recipes;
    }



}
