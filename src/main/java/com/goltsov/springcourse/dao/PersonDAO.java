package com.goltsov.springcourse.dao;

import com.goltsov.springcourse.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;
    
    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        
        return session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
        
        return session.get(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        Person personToUpdate = session.get(Person.class, id);
        personToUpdate.setEmail(updatedPerson.getEmail());
        personToUpdate.setName(updatedPerson.getName());
        personToUpdate.setAge(updatedPerson.getAge());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Person.class, id));
    }

    /////////////////////////////////////
    //// Тестируем производительность Батч-запросов
    ////////////////////////////////////

//    public void testMultiplyUpdates() {
//        List<Person> people = create1000People();
//
//        Long before = System.currentTimeMillis();
//
//        for (Person person : people) {
//            jdbcTemplate.update("INSERT INTO person VALUES (?, ?, ?, ?)",
//                    person.getId(),
//                    person.getName(),
//                    person.getAge(),
//                    person.getEmail()
//            );
//        }
//
//        Long after = System.currentTimeMillis();
//
//        Long time = after - before;
//        System.out.println("Time: " + time);
//
//    }
//
//    private List<Person> create1000People() {
//        List<Person> people = new ArrayList<>();
//
//        for (int i = 15; i < 1015; i++) {
//            people.add(new Person(i, "Name" + i, 25, "email" + i + "@mail.ru"));
//        }
//
//        return people;
//    }
//
//    public void testBatchUpdate() {
//        List<Person> people = create1000People();
//
//        Long before = System.currentTimeMillis();
//
//        jdbcTemplate.batchUpdate("INSERT INTO person VALUES (?, ?, ?, ?)", new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                preparedStatement.setInt(1, people.get(i).getId());
//                preparedStatement.setString(2, people.get(i).getName());
//                preparedStatement.setInt(3, people.get(i).getAge());
//                preparedStatement.setString(4, people.get(i).getEmail());
//            }
//
//            @Override
//            public int getBatchSize() {
//                return people.size();
//            }
//        });
//
//        Long after = System.currentTimeMillis();
//
//        Long time = after - before;
//
//        System.out.println("Time: " + time);
//
//
//    }
}
