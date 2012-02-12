/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.spring.domain.AnnualBudget;
import wad.spring.domain.Team;
import wad.spring.service.BudgetService;
import wad.spring.service.TeamService;

/**
 *
 * @author tonykovanen
 */
@Controller
public class BudgetController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private BudgetService budgetService;
    
    @RequestMapping(value="budget", method=RequestMethod.POST)
    public String addBudget(@Valid @ModelAttribute AnnualBudget budget, BindingResult br, @RequestParam Long teamId) {
        if (br.hasErrors()) {
            return "budget";
        }
        budgetService.saveOrUpdate(budget, teamId);
        return "redirect:/budget";
    }
    @RequestMapping(value="budget", method=RequestMethod.GET)
    public String showBudgets(Model model) {
        model.addAttribute("budgets", budgetService.listAll());
        model.addAttribute("budget", new AnnualBudget());
        model.addAttribute("teams", teamService.list());
        return "budget";
    }
}
