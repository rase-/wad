package wad.controller;

import wad.domain.Olut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wad.services.OlutPalvelu;

@Controller
public class OlutController {

    @Autowired
    private OlutPalvelu olutPalvelu;

    @RequestMapping(method = RequestMethod.GET, value = "olut")
    public String listaaOluet(Model model) {
        model.addAttribute("oluet", olutPalvelu.listaaOluet());
        return "listaus.jsp";
    }

    @RequestMapping(method = RequestMethod.GET, value = "olut/{olutId}")
    public String naytaOlut(Model model, @PathVariable Integer olutId) {
        model.addAttribute("olut", olutPalvelu.annaOlut(olutId));
        return "olutnakyma.jsp";
    }

    @RequestMapping(method = RequestMethod.POST, value = "olut")
    public String lisaaOlut(@RequestParam String nimi) {
        Olut olut = new Olut();
        olut.setName(nimi);
        olutPalvelu.lisaaOlut(olut);
        return "redirect:/olut/" + olut.getId(); // luotu olut
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "olut/{olutId}")
    public String poistaOlut(@PathVariable Integer olutId) {
        olutPalvelu.poistaOlut(olutId);
        return "redirect:/olut";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "olut/{olutId}")
    public String muokkaaTaiLisaaOlut(@ModelAttribute Olut olut, @PathVariable Integer olutId) {
        olut = olutPalvelu.muokkaaTaiLisaaOlut(olutId, olut);
        return "redirect:/olut/" + olut.getId(); // luotu tai muokattu olut
    }
}