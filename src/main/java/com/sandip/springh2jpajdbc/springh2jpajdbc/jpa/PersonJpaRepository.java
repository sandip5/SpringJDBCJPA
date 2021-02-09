package com.sandip.springh2jpajdbc.springh2jpajdbc.jpa;

import com.sandip.springh2jpajdbc.springh2jpajdbc.entity.Person;
import com.sandip.springh2jpajdbc.springh2jpajdbc.jdbc.PersonJdbcDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll() {
        TypedQuery<Person> find_all_persons = entityManager.createNamedQuery("find_all_persons", Person.class);
        return find_all_persons.getResultList();
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }
}
