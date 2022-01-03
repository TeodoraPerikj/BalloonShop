package mk.ukim.finki.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/selectBalloonSize")
public class SelectBalloonController {

    @GetMapping
    public String showSelectBalloonPage(){

        return "selectBalloonSize";
    }

    @PostMapping
    public String selectedSize(HttpServletRequest request){

        String size = request.getParameter("size");

        request.getSession().setAttribute("size", size);

        return "redirect:/BalloonOrder";
    }
}
