/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tonykovanen
 */
@Controller
public class ChatController {
    private Queue<Viesti> viestit = new LinkedList<Viesti>();
    
    @RequestMapping(value = "Chat", method = RequestMethod.GET)
    public String asetaJaNaytaViestit(Model model, HttpSession session, HttpServletRequest request) {
       boolean kirjautunut = tarkistaKirjautuminen(session);
       if (!kirjautunut) {
           return "Login";
       }
       model.addAttribute("viesti", new Viesti());
       model.addAttribute("viestit", viestit);
       model.addAttribute("contextPath", request.getContextPath());
       return "Chat.jsp";
       
    }
    
    @RequestMapping(value = "Chat", method = RequestMethod.POST)
    public String kasitteleUusiViestiJaChattiin(@Valid @ModelAttribute Viesti viesti, BindingResult result, HttpSession session) {
        boolean kirjautunut = tarkistaKirjautuminen(session);
        if(result.hasErrors()) {
            return "Chat.jsp";
        }
        if (!kirjautunut) {
            return "redirect:/Login";
        }
        
        String tunnus = "" + session.getAttribute("tunnus");
        viesti.setTunnus(tunnus);
        if (viestit.size() < 10) {
            viestit.add(viesti);
        } else {
            viestit.poll();
            viestit.add(viesti);
        }
        return "redirect:/Chat";
    }
    private boolean tarkistaKirjautuminen(HttpSession session) {
        if (session.getAttribute("tunnus") == null) {
            return false;
        }
        System.out.println("Tunnus tarkistuksessa: " + session.getAttribute("tunnus"));
        return true;
    }
}

