package com.tiendd.bookservice.responsitory;

import com.tiendd.bookservice.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRespository extends JpaRepository<Person, Long> {
    List<Person> findPersonByType (Long type);
    List<Person> findPersonByTypeAndId (Long type, Long id);
}
