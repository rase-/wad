/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import wad.spring.domain.Course;

/**
 *
 * @author tonykovanen
 */
public interface CourseService {
    void signUpUserToCourse(String username, Long courseId);
    List<Course> list();
    void saveOrUpdateCourse(Course course);
}
