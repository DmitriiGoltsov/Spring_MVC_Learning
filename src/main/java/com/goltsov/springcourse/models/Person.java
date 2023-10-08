package com.goltsov.springcourse.models;


import javax.persistence.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should contain from 2 to 30 letters")
    @Column(name = "name")
    private String name;
    
    @Min(value = 18, message = "User should be older than 18 years old")
    @Column(name = "age")
    private int age;
    
    @Column(name = "email")
    @NotEmpty(message = "Email cannot be blank")
    @Email
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Item> items;
    
    public Person() {
    }
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Person {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", age = " + age +
                ", email = '" + email + '\'' +
                ", items = " + items.toString() +
                '}';
    }
}