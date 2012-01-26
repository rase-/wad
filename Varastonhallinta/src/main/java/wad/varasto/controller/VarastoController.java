/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.varasto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wad.varasto.domain.Esine;
import wad.varasto.service.EsinePalvelu;

/**
 *
 * @author tonykovanen
 */
@Controller
public class VarastoController {

    @Autowired
    private EsinePalvelu esinePalvelu;

    @RequestMapping("*")
    public String nayta() {
        // oletus, ohjataan kaikki pyynnšt listaa-osoitteeseen
        return "redirect:/listaa";
    }
    @RequestMapping("listaa")
    public String listaaEsineet(Model model) {
        model.addAttribute("esineet", esinePalvelu.listaa());
        return "varasto.jsp";
    }
    @RequestMapping(value = "lisaa", method=RequestMethod.POST)
    public String lisaaEsineJaListaa(@ModelAttribute Esine esine) {
        esinePalvelu.lisaa(esine);
        return "listaa";
    }
    @RequestMapping("poista/{esineId}")
    public String poista(@PathVariable Integer esineId) {
        esinePalvelu.poista(esineId);
        return "redirect:/listaa";
    }
}
