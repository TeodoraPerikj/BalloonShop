package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping
    public String saveUser(HttpServletRequest request, Model model){
        User user = null;
        try{

            this.userService.login(request.getParameter("username"), request.getParameter("password"));

            request.getSession().setAttribute("user", user);

            return "redirect:/balloons";
        }catch (InvalidUserCredentialsException exception){

            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }

    }

}
