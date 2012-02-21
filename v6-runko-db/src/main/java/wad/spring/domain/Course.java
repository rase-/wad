/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author tonykovanen
 */
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Pattern(regexp="[a-zA-Z0-9öäÖÄåÅ ]+", message="Kurssin nimessä ei tule olla erikoismerkkejä")
    private String name;
    @OneToOne
    private User lecturer;
    
    @ManyToMany
    private List<User> students;

    public void setId(long id) {
        this.id = id;
    }

    public void setLecturer(User lecturer) {
        this.lecturer = lecturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public List<User> getStudents() {
        return students;
    }


    public void setStudents(List<User> students) {
        this.students = students;
    }

   

    public User getLecturer() {
        return lecturer;
    }

    public String getName() {
        return name;
    }

   public int getAttending() {
       return students.size();
   }

}
