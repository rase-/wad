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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tonykovanen
 */
@Controller
public class ChatController {
    private Queue<Viesti> viestit = new LinkedList<Viesti>();
    
    @RequestMapping("Chat")
    public String asetaJaNaytaViestit(Model model, HttpSession session, HttpServletRequest request) {
       boolean kirjautunut = tarkistaKirjautuminen(session);
       if (!kirjautunut) {
           return "Login";
       }
       model.addAttribute("viestit", viestit);
       model.addAttribute("contextPath", request.getContextPath());
       return "Chat.jsp";
       
    }
    
    @RequestMapping("kommentti")
    public String kasitteleUusiViestiJaChattiin(@RequestParam String viesti, HttpSession session) {
        boolean kirjautunut = tarkistaKirjautuminen(session);
        if (!kirjautunut) {
            return "Login";
        }
        
        String tunnus = "" + session.getAttribute("tunnus");
        Viesti uusiViesti = new Viesti(tunnus, viesti);
        if (viestit.size() < 10) {
            viestit.add(uusiViesti);
        } else {
            viestit.poll();
            viestit.add(uusiViesti);
        }
        return "Chat";
    }
    private boolean tarkistaKirjautuminen(HttpSession session) {
        if (session.getAttribute("tunnus") == null) {
            return false;
        }
        System.out.println("Tunnus tarkistuksessa: " + session.getAttribute("tunnus"));
        return true;
    }
}

