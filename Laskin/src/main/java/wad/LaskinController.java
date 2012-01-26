/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tonykova
 */
@Controller
public class LaskinController {
    @RequestMapping("summa")
    public String summalasku(@RequestParam Integer eka, @RequestParam Integer toka, Model model) {
        int summa = eka + toka;
        model.addAttribute("tulos", summa);
        return "laskin";
    }
    @RequestMapping("kerto")
    public String kertolasku(@RequestParam Integer eka, @RequestParam Integer toka, Model model) {
        int kerto = eka * toka;
        model.addAttribute("tulos", kerto);
        return "laskin";
    }
    @RequestMapping("jako")
    public String jakolasku(@RequestParam Integer eka, @RequestParam Integer toka, Model model) {
        double jako = 1.0 *  eka / toka;
        model.addAttribute("tulos", jako);
        return "laskin";
    }
}
