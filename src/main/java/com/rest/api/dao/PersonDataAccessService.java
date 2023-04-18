package com.rest.api.dao;

import com.rest.api.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonDataAccessService implements PersonDao{
    @Override
    public int insertPerson(UUID uuid, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPerson() {
        return null;
    }

    @Override
    public int deleteById(UUID id) {
        return 0;
    }

    @Override
    public int updateById(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }
}
