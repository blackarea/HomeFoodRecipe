package food.foodrecipe;

import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.Recipe;
import food.foodrecipe.repository.MemberRepository;
import food.foodrecipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@SpringBootApplication
public class FoodrecipeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodrecipeApplication.class, args);
    }

}
