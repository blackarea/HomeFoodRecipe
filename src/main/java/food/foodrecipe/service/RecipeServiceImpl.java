package food.foodrecipe.service;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import food.foodrecipe.domain.QMember;
import food.foodrecipe.domain.QRecipe;
import food.foodrecipe.domain.Recipe;
import food.foodrecipe.domain.form.RecipeForm;
import food.foodrecipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

import static food.foodrecipe.domain.QMember.member;
import static food.foodrecipe.domain.QRecipe.recipe;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final JPAQueryFactory queryFactory;

    public RecipeServiceImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void insertRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void updateRecipe(Long id, RecipeForm recipeForm) {
        Recipe findRecipe = recipeRepository.findById(id).get();
        findRecipe.update(recipeForm.getTitle(), recipeForm.getContent());
        recipeRepository.save(findRecipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipeRepository.findById(id).get();
    }

    /**
     * 모든 레시피 리스트 검색 , 패치조인 이용
     **/
    @Override
    public List<Recipe> getRecipeList() {
        List<Recipe> recipeList = queryFactory
                .selectFrom(recipe)
                .join(recipe.member, member).fetchJoin()
                .fetch();
        return recipeList;
    }

    @Override
    public Page<Recipe> getRecipeListPaging(int page) {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "recipe_id");

        if(page < 0){
            page = 0;
        }


        QueryResults<Recipe> recipeQueryResults = queryFactory
                .selectFrom(recipe)
                .join(recipe.member, member).fetchJoin()
                .offset(page*10)
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Recipe> results = recipeQueryResults.getResults();
        long total = recipeQueryResults.getTotal();

        return new PageImpl<>(results, pageable, total);
    }



}
