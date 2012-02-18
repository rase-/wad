/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.controller;

import javax.naming.Binding;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import wad.spring.domain.Aines;
import wad.spring.domain.Resepti;
import wad.spring.service.AinesService;
import wad.spring.service.ReseptiService;

/**
 *
 * @author tonykovanen
 */
@Controller
public class ReseptiController {
    @Autowired
    ReseptiService reseptiService;
    @Autowired
    AinesService ainesService;
    
    @RequestMapping(value="resepti", method=RequestMethod.GET)
    public String naytaReseptit(Model model) {
        model.addAttribute("resepti", new Resepti());
        model.addAttribute("reseptit", reseptiService.listAll());
        return "resepti";
    }
    @RequestMapping(value="resepti", method=RequestMethod.POST)
    public String uusiResepti(@Valid @ModelAttribute Resepti resepti, BindingResult result) {
        if (result.hasErrors()) {
            return "resepti";
        }
        reseptiService.saveOrUpdate(resepti);
        return "redirect:/resepti";
    }
    @RequestMapping(value="aines", method=RequestMethod.GET)
    public String naytaAinekset(Model model) {
        model.addAttribute("aines", new Aines());
        model.addAttribute("ainekset", ainesService.listAll());
        return "aines";
    }
    @RequestMapping(value="aines", method=RequestMethod.POST)
    public String uusiAines(@Valid @ModelAttribute Aines aines, BindingResult result) {
        if (result.hasErrors()) {
            return "aines";
        }
        ainesService.save(aines);
        return "redirect:/aines";
    }
    @RequestMapping(value="resepti/{reseptiId}", method=RequestMethod.GET)
    public String naytaResepti(@PathVariable Long reseptiId, Model model) {
        Resepti resepti = reseptiService.findOne(reseptiId);
        model.addAttribute("resepti", resepti);
        model.addAttribute("ainekset", ainesService.listAll());
        return "reseptinakyma";
    }
    @RequestMapping(value="resepti/{reseptiId}", method=RequestMethod.DELETE)
    public String poistaResepti(@PathVariable Long reseptiId) {
        reseptiService.delete(reseptiId);
        return "redirect:/resepti";
    }
    @RequestMapping(value="resepti/{reseptiId}", method=RequestMethod.POST)
    public String lisaaAines(@RequestParam Long ainesId, @PathVariable Long reseptiId) {
        Aines aines = ainesService.findOne(ainesId);
        ainesService.saveOrUpdate(aines, reseptiId);
        return "redirect:/resepti/" + reseptiId;
    }
    @RequestMapping(value="/poista/{reseptiId}", method=RequestMethod.GET)
    public String poistaUrlissa(@PathVariable Long reseptiId) {
        reseptiService.delete(reseptiId);
        return "redirect:/resepti";
    }
    @RequestMapping(value="aines/{ainesId}", method=RequestMethod.GET)
    public String naytaAines(@PathVariable Long ainesId, Model model) {
        Aines aines = ainesService.findOne(ainesId);
        model.addAttribute("aines", aines);
        return "ainesnakyma";
    }
}
