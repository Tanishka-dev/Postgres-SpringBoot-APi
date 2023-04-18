package com.rest.api.dao;

import com.rest.api.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static sun.net.www.http.KeepAliveCache.result;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    public PersonDataAccessService(JdbcTemplate jdbcTemplate{
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int insertPerson(UUID uuid, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPerson() {
        String sql = "SELECT id, name FROM person";
       List<Person> people= jdbcTemplate.query(sql,(resultSet,i)->{
            UUID id= UUID.fromString(resultSet.getString("id"));
            String name=  resultSet.getString("name");
            return new Person(id, name);
        }
    );
        return people;
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
