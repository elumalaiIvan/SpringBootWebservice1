package com.spring.demo.service;

import com.spring.demo.dao.PersonDao;
import com.spring.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sun.dc.path.PathError;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgresDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPerson() {
        return personDao.selectAllPersons();
    }

    public Optional<Person> getPerson(UUID id) {
        return personDao.selectPerson(id);
    }

    public int removePerson(UUID id) {
        return personDao.deletePerson(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDao.updatePerson(id, person);
    }
}
