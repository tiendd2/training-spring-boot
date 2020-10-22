package com.tiendd.bookservice.api.endpoint;

import com.tiendd.bookservice.api.model.Book;
import com.tiendd.bookservice.api.model.Person;
import com.tiendd.bookservice.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonEndpoint {
    @Autowired
    private PersonService personService;

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable(name = "id") Long id){
        boolean result = personService.deleteItem(id);
        if(result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public Person edit(@RequestBody Person person){
        return (Person) personService.editItem(person);
    }

    @PostMapping("/add")
    public Book addPerson(@RequestBody Person person) {
        return (Book) personService.addItem(person);
    }

    /* employee api */
    @GetMapping("/employee/all")
    public List<Person> getListEmployee() {
        return personService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Book getEmployee(@PathVariable(name = "id") Long id){
        return (Book) personService.getEmployeeById(id);
    }

    /* customer api */
    @GetMapping("/customer/all")
    public List<Person> getCustomers() {
        return personService.getCustomers();
    }

    @GetMapping("/customer/{id}")
    public Book getCustomer(@PathVariable(name = "id") Long id){
        return (Book) personService.getCustomerById(id);
    }


}
