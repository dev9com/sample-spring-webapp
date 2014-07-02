package com.dev9.web.controller;

import com.dev9.web.model.Address;
import com.dev9.web.model.Person;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person saveCustomer(@RequestBody String serializedPerson) throws IOException {

        // Simulate some sort of an "update"
        Person person = mapper.readValue(serializedPerson, Person.class);
        person.setAddress(new Address("500 Linden Street", "Fort Collins", "CO", "80526"));

        return person;
    }

    @RequestMapping(value = "/person", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@RequestBody String personString) throws IOException {

//        Person person = mapper.readValue(personString, Person.class);
        // delete person
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCustomer(@RequestBody String personString) throws IOException {

        // Simulate some sort of an "save"
        Person person = mapper.readValue(personString, Person.class);
        person.setAddress(new Address("500 Linden Street", "Fort Collins", "CO", "80526"));

    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person getCustomer(@RequestParam("firstName") String firstName, @RequestParam("firstName") String lastName) throws IOException {

        // Simulate some sort of an "get"
        Person person = new Person(firstName, lastName);
        person.setAddress(new Address("500 Linden Street", "Fort Collins", "CO", "80526"));

        return person;
    }

}
