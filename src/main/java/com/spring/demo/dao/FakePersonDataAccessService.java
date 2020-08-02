package com.spring.demo.dao;

import com.spring.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPersons() {
        return DB;
    }

    @Override
    public int deletePerson(UUID id) {
       return DB.remove(selectPerson(id).get()) ? 1 : 0;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return selectPerson(id)
                .map(p -> DB.set(DB.indexOf(p), person) == null ? 0 : 1)
                .orElse(0);
    }

    @Override
    public Optional<Person> selectPerson(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
}
