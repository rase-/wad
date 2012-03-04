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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.spring.domain.Course;
import wad.spring.domain.Role;
import wad.spring.domain.StudentFormObject;
import wad.spring.domain.User;
import wad.spring.repository.CourseRepository;
import wad.spring.repository.UserRepository;
import wad.spring.service.CourseService;
import wad.spring.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model, Principal principal) {
        model.addAttribute("student", userService.findUserByUsername(principal.getName()));
        model.addAttribute("studentform", new StudentFormObject());
        return "student/home";
    }

    @RequestMapping(value = "home", method = RequestMethod.POST)
    public String changeInformation(@Valid @ModelAttribute("studentform") StudentFormObject studentform, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "student/home";
        }
        User user = userService.findUserByUsername(principal.getName());
        user.setName(studentform.getName());
        user.setPassword(studentform.getPassword());
        userService.saveOrUpdateUser(user);
        return "redirect:/student/home";
    }

    @RequestMapping(value = "course/{courseId}", method = RequestMethod.GET)
    public String signUpToCourse(@PathVariable Long courseId, Principal principal) {
        courseService.signUpUserToCourse(principal.getName(), courseId);
        return "redirect:/home";
    }
}
