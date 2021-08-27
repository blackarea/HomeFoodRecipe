package food.foodrecipe.service;

import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.Recipe;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecipeService {
    void insertRecipe(Recipe recipe);
    void updateRecipe(Recipe recipe);
    void deleteRecipe(Recipe recipe);
    Recipe getRecipe(Long id);
    List<Recipe> getRecipeList();
    //Page<Recipe> getRecipeList(Recipe recipe);
}
