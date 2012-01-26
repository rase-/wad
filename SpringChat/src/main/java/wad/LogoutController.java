/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tonykovanen
 */
@Controller
public class LogoutController {
    @RequestMapping("Logout")
    public String invalidoiSessioJaKirjautumiseen(HttpSession session) {
        session.invalidate();
        return "Login";
    }
}
