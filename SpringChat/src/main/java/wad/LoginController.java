/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tonykovanen
 */
@Controller
public class LoginController {
    @RequestMapping(value = "Login", method = RequestMethod.GET)
    public String ohjaaFormiin() {
        return "Login.jsp";
    }
    @RequestMapping(value = "Login", method = RequestMethod.POST)
    public String otaAttribuutitJaChattiin(@RequestParam String tunnus, HttpSession session) {
        session.setAttribute("tunnus", tunnus);
        return "Chat";
    }
}
