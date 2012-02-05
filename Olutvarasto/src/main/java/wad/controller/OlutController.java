package wad.controller;

import java.util.List;
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
        return "/olutnakyma.jsp";
    }

    @RequestMapping(method = RequestMethod.POST, value = "olut")
    public String lisaaOlut(@RequestParam String name) {
        Olut olut = new Olut();
        olut.setName(name);
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
    @RequestMapping(method = RequestMethod.GET, value="olut/{olutId}.json")
    @ResponseBody
    public Olut naytaJSONOlut(Model model, @PathVariable Integer olutid) {
        return olutPalvelu.annaOlut(olutid);
    }
    @RequestMapping(method = RequestMethod.GET, value = "olut.json")
    @ResponseBody
    public List<Olut> listaaJSONOluet(Model model) {
        return olutPalvelu.listaaOluet();
    }
    @RequestMapping(method = RequestMethod.PUT, value="olut/{olutId}.json", consumes="application/json")
    public String muokkaaJSONOlut(@RequestBody Olut olut, @PathVariable Integer olutId) {
        olut = olutPalvelu.muokkaaTaiLisaaOlut(olutId, olut);
        return "redirect:/olut/" +  olut.getId();
    }
    @RequestMapping(method = RequestMethod.POST, value="olut.json", consumes = "application/json")
    public String lisaaJSONOlut(@RequestBody Olut olut, Model model) {
        olutPalvelu.lisaaOlut(olut);
        model.addAttribute("oluet", olutPalvelu.listaaOluet());
        return "listaus.jsp";
    }
}