package food.foodrecipe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/security/accessdenied")
    public String accessDenied(){
        return "false sign in";
    }
}
