package com.rest.api.api;

import com.rest.api.model.Person;
import com.rest.api.service.PersonService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @GetMapping(path = "{id}") //take id from apiS
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
        //if no id is found, send null
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable("id") UUID id){
        personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void updateById(@PathVariable("id") UUID id, @NotNull @RequestBody Person personToUpdate){
        personService.updatePersonById(id, personToUpdate);
    }
}
