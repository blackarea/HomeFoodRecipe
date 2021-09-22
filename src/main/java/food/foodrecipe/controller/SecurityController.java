package food.foodrecipe.controller;

import food.foodrecipe.domain.form.MemberForm;
import food.foodrecipe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired private MemberService memberService;

    @GetMapping("/login")
    public String loginView(){
        return "/security/login";
    }

    @GetMapping("/logout")
    public String  logout(){
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerView(){
        return "/security/register";
    }

    @PostMapping("/register")
    public String register(MemberForm memberForm){
        memberService.save(memberForm);
        return "redirect:/";
    }

}
