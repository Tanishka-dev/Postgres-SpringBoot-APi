package com.rest.api.dao;

import com.rest.api.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB= new ArrayList<Person>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPerson() {
        return DB;
    }

    @Override
    public int deleteById(UUID id) {
        Optional<Person> personToBeDeleted = selectPersonById(id);
        if (personToBeDeleted.isEmpty()){
            return 0;
        }
        DB.remove(personToBeDeleted.get());
        return 1;
    }

    @Override
    public int updateById(UUID id, Person newperson) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if(indexOfPersonToUpdate>=0){
                        DB.set(indexOfPersonToUpdate,new Person(id, newperson.getName()));
                        return 1;
                    }
                    return 0;

                })
                .orElse(0);
        //if not present the return 0
    }
    //updating a person name with another person

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst(); //filter all person according to given id
    }
}
