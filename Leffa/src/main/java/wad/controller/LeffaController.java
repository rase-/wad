/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Genre;
import wad.domain.Leffa;
import wad.services.*;

/**
 *
 * @author tonykovanen
 */
@Controller
public class LeffaController {
   @Autowired
   LeffaPalvelu leffaPalvelu;
   
   @Autowired
   GenrePalvelu genrePalvelu;
   
   @RequestMapping("*")
   public String ohjaa() {
       return "redirect:/listaa";
   }
   
   @RequestMapping("listaa")
   public String listaa(Model model) {
       List<Leffa> leffat = leffaPalvelu.listaa();
       model.addAttribute("elokuvat", leffat);
       return "leffat";
   }
   @RequestMapping(value = "lisaa", method = RequestMethod.POST)
   public String lisaaElokuva(@ModelAttribute Leffa leffa) {
       leffaPalvelu.lisaa(leffa);
       return "redirect:/listaa";
   }
   @RequestMapping(value = "lisaaGenre", method = RequestMethod.POST)
   public String lisaaGenre(@ModelAttribute Genre genre) {
       genrePalvelu.lisaa(genre);
       return "redirect:/listaaGenret";
   }
   @RequestMapping("listaaGenret")
   public String listaaGenret(Model model) {
       model.addAttribute("genret", genrePalvelu.listaa());
       return "genret";
   }
   @RequestMapping("lisaaElokuvalleGenre/{elokuvaId}/{genreNimi}")
   public String lisaaElokuvalleGenre(@PathVariable Integer elokuvaId, @PathVariable String genreNimi) {
       Leffa leffa = leffaPalvelu.hae(elokuvaId);
       Genre genre = genrePalvelu.hae(genreNimi);
       leffa.lisaaGenre(genre);
       genre.lisaaLeffa(leffa);
       leffaPalvelu.update(leffa);
       genrePalvelu.update(genre);
       return "redirect:/listaa";
   }
   @RequestMapping("nayta/{elokuvaId}")
   public String naytaElokuva(@PathVariable Integer elokuvaId, Model model) {
       Leffa leffa = leffaPalvelu.hae(elokuvaId);
       model.addAttribute("elokuva", leffa);
       model.addAttribute("genret", leffa.getGenret());
       return "elokuvanakyma";
   }
   @RequestMapping("naytaGenrella/{genreNimi}")
   public String naytaGenrella(@PathVariable String genreNimi, Model model) {
       Genre genre = genrePalvelu.hae(genreNimi);
       model.addAttribute("genre", genre);
       model.addAttribute("elokuvat", genre.getLeffat());
       return "genrenakyma";
   }
}
