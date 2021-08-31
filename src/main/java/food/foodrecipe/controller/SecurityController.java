package food.foodrecipe.controller;

import food.foodrecipe.domain.Member;
import food.foodrecipe.domain.form.LoginForm;
import food.foodrecipe.domain.form.MemberForm;
import food.foodrecipe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    /*@PostMapping("/login")
    public String login(LoginForm loginForm){
        System.out.println(loginForm.getPassword()+" "+ loginForm.getUser_id());
        Member loginMember = memberService.login(loginForm.getUser_id(), loginForm.getPassword());
        System.out.println(loginMember.toString());
        return "forward:/";
    }*/

    @GetMapping("/logout")
    public void logout(){

    }

    @GetMapping("/register")
    public String registerView(){
        return "/security/register";
    }

    @PostMapping("/register")
    public String register(MemberForm memberForm){


        return "redirect:/";
    }

}
