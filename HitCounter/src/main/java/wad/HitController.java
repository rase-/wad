/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tonykovanen
 */
@Controller
public class HitController {
    
    @Autowired
    HitCounter hitcounter;
    
    @RequestMapping("hitme")
    public String incrementAndReturn(Model model) {
        hitcounter.incrementCount();
        model.addAttribute("hits", hitcounter.getCount());
        
        return "check.jsp";
    }
}
