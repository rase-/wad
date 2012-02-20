package wad.spring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.spring.domain.Role;
import wad.spring.domain.StudentFormObject;
import wad.spring.domain.User;
import wad.spring.repository.UserRepository;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    UserRepository userRepo;
    
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model, Principal principal) {
        model.addAttribute("student", userRepo.findByUsername(principal.getName()));
        model.addAttribute("studentform", new StudentFormObject());
        return "student/home";
    }
    @RequestMapping(value = "home", method = RequestMethod.POST)
    public String changeInformation(@Valid @ModelAttribute StudentFormObject studentform, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "student/home";
        }
        User user = userRepo.findByUsername(principal.getName());
        user.setName(studentform.getName());
        user.setPassword(studentform.getPassword());
        userRepo.save(user);
        return "redirect:/student/home";
    }
}
