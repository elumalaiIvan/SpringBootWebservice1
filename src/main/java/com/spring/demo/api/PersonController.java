package com.spring.demo.api;

import com.spring.demo.model.Person;
import com.spring.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping(path = "{id}")
    public Person getPerson(@PathVariable("id") UUID id) {
        return personService.getPerson(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public  int removePerson(@PathVariable("id") UUID id) {
        return personService.removePerson(id);
    }

    @PutMapping(path = "{id}")
    public  int updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }
}
