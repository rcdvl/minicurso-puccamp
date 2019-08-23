package br.org.sidi.puccamp.minicurso.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String fullName;

    @ManyToMany
    @JoinTable(name = "friends",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "friendId"))
    private Set<Student> friends;

    public Student() {
    }

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Student> getFriends() {
        return friends;
    }

    public void setFriends(Set<Student> friends) {
        this.friends = friends;
    }
}
