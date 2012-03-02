package wad.spring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.spring.domain.Course;
import wad.spring.domain.Role;
import wad.spring.domain.SampleObject;
import wad.spring.domain.User;
import wad.spring.repository.CourseRepository;
import wad.spring.repository.UserRepository;
import wad.spring.service.ObjectFactory;
import wad.spring.service.SecureService;

@Controller
public class HomeController {
    @Autowired
    CourseRepository courseRepo;
    
    @Autowired
    UserRepository userRepo;
    @Autowired
    SecureService secureService;
    @Autowired
    ObjectFactory postFilterExample;

    @RequestMapping(value = "/home")
    public String home(Model model) {
        secureService.executeFreely();
        List<User> users = userRepo.findAll();
        List<User> students = new ArrayList<User>();
        List<Course> courses = courseRepo.findAll();
        for (User u : users) {
            for (Role r : u.getRoles()) {
                if (r.getRolename().equals("student")) {
                    students.add(u);
                    break;
                }
            }
        }
        model.addAttribute("courses", courses);
        model.addAttribute("students", students);
        return "home";
    }

    @RequestMapping(value = "/must-be-authenticated")
    public String mustAuth() {
        secureService.executeOnlyIfAuthenticated();
        return "home";
    }

    @RequestMapping(value = "/must-be-admin")
    public String mustAdmin() {
        secureService.executeOnlyIfAuthenticatedAsLecturer();
        return "home";
    }

    @RequestMapping(value = "/are-they-awesome")
    public String areTheyAwesome(Principal principal) {
        if (principal == null) {
            System.out.println("Not logged in!");
        } else {
            System.out.println("Logged in username, if any: " + principal.getName());
        }

        for (SampleObject obj : postFilterExample.getObjects()) {
            System.out.println("" + obj.isAwesome());
        }

        return "home";
    }
}
