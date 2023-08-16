package com.goltsov.springcourse.dao;

import com.goltsov.springcourse.models.Person;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Thomas", 25, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Igor", 29, "igor@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Anna", 21, "anna@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 31, "bean@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person showPersonById(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }

    public Person showPersonByName(String name) {
        return people.stream()
                .filter(person -> person.getName().equals(name))
                .findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = showPersonById(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
