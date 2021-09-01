package food.foodrecipe.controller;

import food.foodrecipe.config.SecurityUser;
import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.Recipe;
import food.foodrecipe.domain.form.RecipeForm;
import food.foodrecipe.repository.MemberRepository;
import food.foodrecipe.repository.RecipeRepository;
import food.foodrecipe.service.MemberService;
import food.foodrecipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired private MemberService memberService;
    @Autowired private RecipeService recipeService;
    @Autowired private RecipeRepository recipeRepository;

    @GetMapping("/getmyrecipelist")
    public String getMyRecipeList(Model model, @AuthenticationPrincipal SecurityUser principal){
        Member member = principal.getMember();
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
    public String insertRecipeView(){
        return "/member/insertRecipe";
    }

    @PostMapping("/insertrecipe")
    public String insertRecipe(RecipeForm recipeForm, @AuthenticationPrincipal SecurityUser principal){
        Member member = principal.getMember();
        Recipe recipe1 = new Recipe(recipeForm.getTitle(), recipeForm.getContent(), member);
        recipeService.insertRecipe(recipe1);
        return "redirect:/member/getmyrecipelist";
    }

    @GetMapping("/updaterecipe/{id}")
    public String updateRecipeView(@PathVariable Long id, Model model){
        Recipe recipe = recipeRepository.findById(id).get();
        model.addAttribute("recipe", recipe);
        return "/member/updateRecipe";
    }

    @PostMapping("/updaterecipe/{id}")
    public String updateRecipe(@PathVariable Long id, RecipeForm recipeForm){
        recipeService.updateRecipe(id, recipeForm);
        return "redirect:/member/getmyrecipelist";
    }
}
