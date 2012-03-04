/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Course;
import wad.spring.domain.Role;
import wad.spring.domain.User;
import wad.spring.repository.UserRepository;

/**
 *
 * @author tonykovanen
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;
    
    @Transactional(readOnly = true)
    @Override
    public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    @Transactional
    @Override
    public void saveOrUpdateUser(User user) {
        userRepo.save(user);
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<User> getStudents() {
        List<User> users = userRepo.findAll();
        List<User> students = new ArrayList<User>();
        for (User u : users) {
            for (Role r : u.getRoles()) {
                if (r.getRolename().equals("student")) {
                    students.add(u);
                    break;
                }
            }
        }
        return students;
    }
    
}
