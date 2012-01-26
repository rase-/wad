package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.service.TehdytTehtavat;

@Controller
public class TarkistusController {
    @Autowired
    TehdytTehtavat tarkistaja;
    
    @RequestMapping(value = "tarkistus", method = RequestMethod.GET)
    public String naytaSivu() {
        return "tarkistus.jsp";
    }
    @RequestMapping(value = "check", method = RequestMethod.POST)
    public String palauta(@RequestParam String opiskelijanumero, Model model) {
        tarkistaja.setOpnro(opiskelijanumero);
        model.addAttribute("tulos", tarkistaja.annaSisalto());
        return "tulos.jsp";
    }
}
