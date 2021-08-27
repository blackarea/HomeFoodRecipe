package food.foodrecipe.controller;

import food.foodrecipe.domain.Recipe;
import food.foodrecipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired private RecipeService recipeService;

    @GetMapping("/getrecipelist")
    public String getRecipeList(Model model){
        List<Recipe> recipeList = recipeService.getRecipeList();
        model.addAttribute("recipeList", recipeList);
        return "/recipe/getRecipeList";
    }

    @GetMapping("/getrecipe")
    public String getRecipe(@RequestParam Long id, Model model){
        Recipe getRecipe = recipeService.getRecipe(id);
        model.addAttribute("recipe", getRecipe);
        return "/recipe/getRecipe";
    }
}
