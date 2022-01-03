package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ConfirmationInfo")
public class ConfirmationInfoController {

    @GetMapping
    public String getConfirmationPage(HttpServletRequest request, Model model){

        model.addAttribute("ipAddress", request.getRemoteAddr());
        model.addAttribute("userAgent", request.getHeader("User-Agent"));

        return "confirmationInfo";
    }

    @PostMapping
    public String confirmInfo(HttpServletRequest request, Model model){

        return "redirect:/orders";
    }

}
