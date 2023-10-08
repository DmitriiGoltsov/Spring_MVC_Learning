package com.goltsov.springcourse.repositories;

import com.goltsov.springcourse.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    List<Person> findPeopleByName(String name);
    List<Person> findPeopleByNameOrderByAge(String name);
    List<Person> findPeopleByEmail(String email);
    List<Person> findPeopleByNameStartingWith(String startingWith);
    List<Person> findPeopleByNameOrEmail(String name, String email);
}
