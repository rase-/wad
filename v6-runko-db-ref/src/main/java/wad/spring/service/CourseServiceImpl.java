/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Course;
import wad.spring.domain.User;
import wad.spring.repository.CourseRepository;
import wad.spring.repository.UserRepository;

/**
 *
 * @author tonykovanen
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepo;
    
    @Autowired
    UserRepository userRepo;
    
    
    @Override
    @Transactional(readOnly = true)
    public void signUpUserToCourse(String username, Long courseId) {
        User user = userRepo.findByUsername(username);
        Course course = courseRepo.findOne(courseId);
        for (User u : course.getStudents()) {
            if (u.getUsername().equals(user.getUsername())) {
                return;
            }
        }
        course.getStudents().add(user);
        courseRepo.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> list() {
        return courseRepo.findAll();
    }

    @Override
    @Transactional
    public void saveOrUpdateCourse(Course course) {
        courseRepo.save(course);
    }
    
}
