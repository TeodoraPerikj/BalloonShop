package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.lab.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "register";
    }

    @PostMapping
    public String saveNewUser(HttpServletRequest request, Model model){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatPass = request.getParameter("repeatedPassword");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String dateOfBirth = request.getParameter("datum");

        try {

            this.userService.register(username,password,repeatPass,name,surname,dateOfBirth);
            return "redirect:/login";
        }catch (PasswordsDoNotMatchException | InvalidArgumentsException exception){
            return "redirect:/register?error="+exception.getMessage();
        }

    }
}
