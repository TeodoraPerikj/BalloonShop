package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.model.Manufacturer;
import mk.ukim.finki.lab.model.exceptions.BalloonNotFoundException;
import mk.ukim.finki.lab.model.exceptions.ManufacturerNotExistsException;
import mk.ukim.finki.lab.service.BalloonService;
import mk.ukim.finki.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){

        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("balloons",this.balloonService.listAll());

        return "listBalloons";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name, @RequestParam String description, @RequestParam Long manId){

        Manufacturer manufacturer = this.manufacturerService.findById(manId)
                .orElseThrow(()->new ManufacturerNotExistsException(manId));

        this.balloonService.saveOrUpdate(name, description, manufacturer);

        return "redirect:/balloons";

    }

    @GetMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){

        if(this.balloonService.findById(id).isPresent()){
            this.balloonService.deleteById(id);
            return "redirect:/balloons";
        }

        BalloonNotFoundException exception = new BalloonNotFoundException(id);

        return "redirect:/balloons?error="+exception;
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){

        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);

        return "add-balloon";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model){

        if(this.balloonService.findById(id).isPresent()){

            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturers);
            model.addAttribute("balloon", this.balloonService.findById(id).get());

            return "add-balloon";
        }

        BalloonNotFoundException exception = new BalloonNotFoundException(id);

        return "redirect:/balloons?error="+exception;
    }

    @PostMapping
    public String selectedColor(HttpServletRequest request){

        String color = request.getParameter("color");

        request.getSession().setAttribute("color", color);

        return "redirect:/selectBalloonSize";
    }

}
