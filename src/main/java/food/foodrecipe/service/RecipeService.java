package food.foodrecipe.service;

import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.Recipe;
import food.foodrecipe.domain.form.RecipeForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecipeService {
    void insertRecipe(Recipe recipe);
    void updateRecipe(Long id, RecipeForm recipeForm);
    void deleteRecipe(Long id);
    Recipe getRecipe(Long id);
    List<Recipe> getRecipeList();
    Page<Recipe> getRecipeListPaging(int page);
}
