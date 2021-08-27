package food.foodrecipe.service;

import food.foodrecipe.domain.Recipe;
import food.foodrecipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void insertRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        Recipe findRecipe = recipeRepository.findById(recipe.getId()).get();

        findRecipe.update(recipe.getTitle(), recipe.getContent());
        //recipeRepository.save(findRecipe);
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        recipeRepository.deleteById(recipe.getId());
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipeRepository.findById(id).get();
    }

    @Override
    public List<Recipe> getRecipeList() {
        List<Recipe> all = recipeRepository.findAll();
        return all;
    }


    /*@Override
    public Page<Recipe> getRecipeList(Recipe recipe) {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "recipe_id");
        return recipeRepository.getRecipeList(pageable);
    }*/



}