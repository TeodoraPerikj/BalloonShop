package mk.ukim.finki.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/BalloonOrder")
public class BalloonOrderController {

    @GetMapping
    public String getBalloonOrder(){
        return "deliveryInfo";
    }

    @PostMapping
    public String deliverInfo(HttpServletRequest request){

        String clientName =  request.getParameter("clientName");
        String clientAddress = request.getParameter("clientAddress");

        request.getSession().setAttribute("clientName",clientName);
        request.getSession().setAttribute("clientAddress", clientAddress);

        return "redirect:/ConfirmationInfo";

    }

}
