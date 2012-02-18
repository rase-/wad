package wad.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.spring.service.MaailmaPalvelu;

@Controller
public class HomeController {
    @Autowired
    MaailmaPalvelu palvelu;
    
    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }
    @RequestMapping(value = "/maailma")
    public String maailma(Model model) {
        palvelu.pyyda();
        model.addAttribute("content", palvelu.lue());
        return "maailma";
    }
}
