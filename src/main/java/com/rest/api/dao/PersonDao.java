package com.rest.api.dao;
//operations allowed

import com.rest.api.model.Person;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface PersonDao {
    int insertPerson(UUID uuid, Person person);

    default int insertPerson(Person person){ //without id
        UUID id= UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> selectAllPerson();

    int deleteById(UUID id);

    int updateById(UUID id, Person person);

    Optional<Person> selectPersonById(UUID id);

}
