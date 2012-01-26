/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author tonykova
 */
@Controller
public class IlmoittautuminenController {

    @RequestMapping(value = "osallistuminen", method = RequestMethod.GET)
    public String o(Model model) {

        return "index.jsp";
    }

    @RequestMapping(value = "osallistu", method = RequestMethod.POST)
    public String otaOsallistuminen(@ModelAttribute Osallistuja osallistuja, Model model) {
        model.addAttribute("osallistuja", osallistuja);

        return "ilmoittautuminen.jsp";
    }
}
