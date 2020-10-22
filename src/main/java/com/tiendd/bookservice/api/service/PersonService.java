package com.tiendd.bookservice.api.service;

import com.tiendd.bookservice.api.model.Person;
import com.tiendd.bookservice.utils.core.Constant;
import com.tiendd.bookservice.responsitory.PersonRespository;
import com.tiendd.bookservice.utils.validator.CommonValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends CommonService {
    public PersonService(@Qualifier("personRespository") JpaRepository repository,
                         @Qualifier("person") CommonValidator validator) {
        super(repository, validator);
    }

    public List<Person> getCustomers() {
        return ((PersonRespository) repository).findPersonByType(Constant.CUSTOMER_TYPE);
    }

    public List<Person> getCustomerById(Long id) {
        return ((PersonRespository) repository).findPersonByTypeAndId(Constant.CUSTOMER_TYPE, id);
    }

    public List<Person> getEmployees() {
        return ((PersonRespository) repository).findPersonByType(Constant.EMPLOYEE_TYPE);
    }
    public List<Person> getEmployeeById(Long id) {
        return ((PersonRespository) repository).findPersonByTypeAndId(Constant.EMPLOYEE_TYPE, id);
    }
}
