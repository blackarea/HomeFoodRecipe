package food.foodrecipe.controller;

import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.Recipe;
import food.foodrecipe.domain.form.RecipeForm;
import food.foodrecipe.repository.MemberRepository;
import food.foodrecipe.service.MemberService;
import food.foodrecipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;
    @Autowired RecipeService recipeService;
    @Autowired MemberRepository memberRepository;

    @GetMapping("/getmyrecipelist")
    public String getMyRecipeList(Model model){
        Member member = memberRepository.findById(1L).get();
        List<Recipe> myRecipeList = memberService.getMyRecipeList(member);
        model.addAttribute("recipeList", myRecipeList);
        model.addAttribute("id", 1L);
        return "/member/getMyRecipeList";
    }

    @GetMapping("/getrecipe")
    public String getRecipe(@RequestParam Long id, Model model){
        Recipe getRecipe = recipeService.getRecipe(id);
        model.addAttribute("recipe", getRecipe);
        return "/member/getRecipe";
    }

    @GetMapping("/insertrecipe")
    public String insertRecipeListView(){
        return "/member/insertRecipe";
    }

    @PostMapping("/insertrecipe")
    public String insertRecipeList(RecipeForm recipeForm){
        Member member = memberRepository.findById(1L).get();
        Recipe recipe1 = new Recipe(recipeForm.getTitle(), recipeForm.getContent(), member);
        recipeService.insertRecipe(recipe1);
        return "redirect:/member/getmyrecipeList";
    }
}
