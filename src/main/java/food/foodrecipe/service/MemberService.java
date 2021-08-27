package food.foodrecipe.service;

import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.form.MemberForm;
import food.foodrecipe.domain.Recipe;

import java.util.List;

public interface MemberService {
    Member save(MemberForm memberForm);
    List<Recipe> getMyRecipeList(Member member);
    Member login(String user_id, String password);
}
