package food.foodrecipe.service;

import food.foodrecipe.domain.Recipe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceImplTest {

    @Autowired
    RecipeService recipeService;

    @Test
    void getRecipeListPagingTest(){
        Page<Recipe> result = recipeService.getRecipeListPaging(5);
        System.out.println(result.getNumber());
        System.out.println(result.getSize());
        System.out.println(result.getTotalElements());
        System.out.println(result.getTotalPages());
    }
}