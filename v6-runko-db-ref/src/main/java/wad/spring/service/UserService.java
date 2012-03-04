/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import wad.spring.domain.User;

/**
 *
 * @author tonykovanen
 */
public interface UserService {
    User findUserByUsername(String username);
    void saveOrUpdateUser(User user);
    List<User> getStudents();
}
