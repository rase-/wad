/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.service.HitCounter;



/**
 *
 * @author tonykovanen
 */
@Controller
public class HitController {
    @Autowired
    HitCounter hitcounter;
    
    @RequestMapping("hitme")
    public String HitCounter(Model model) {
        int hits = hitcounter.getAndIncrementCounter();
        model.addAttribute("hits", hits);
        return "hits.jsp";
    }
}
