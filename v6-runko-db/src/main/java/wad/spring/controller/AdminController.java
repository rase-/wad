package wad.spring.controller;

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
import wad.spring.service.SecureService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("studentform", new StudentFormObject());
        return "admin/home";
    }
    
    @RequestMapping(value = "home", method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute StudentFormObject studentform, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/home";
        }
        User user = new User();
        user.setName(studentform.getName());
        user.setUsername(studentform.getUsername());
        if (studentform.getPassword() != null && !studentform.getPassword().equals("")) {
            user.setPassword(studentform.getPassword());
        } else {
            user.setPassword("vaihda");
        }
        Role role = new Role();
        role.setRolename("student");
        List<Role> list = new ArrayList<Role>();
        list.add(role);
        user.setRoles(list);
        userRepo.save(user);
        return "redirect:/admin/home";
    }
}
