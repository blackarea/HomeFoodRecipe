package food.foodrecipe.controller;

import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.Recipe;
import food.foodrecipe.repository.MemberRepository;
import food.foodrecipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @PostConstruct
    public void saveMember(){

        IntStream.rangeClosed(1, 5).forEach(i -> {
            Member member = Member.builder()
                    .user_id("user" + i)
                    .password("pwd"+ i)
                    .name("name" +i)
                    .build();
            memberRepository.save(member);

            Recipe recipe = new Recipe("title" + i, "content" + i, member);
            recipeRepository.save(recipe);

        });
    }

    @GetMapping("/")
    public String home(Model model){
        return "/home/home";
    }

    
}