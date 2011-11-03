package com.dynacrongroup.web.controller;

import com.dynacrongroup.web.model.Address;
import com.dynacrongroup.web.model.Person;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseBody
    public Person showOffJackson(@RequestBody String personString) throws IOException {

        Person person = mapper.readValue(personString, Person.class);
        person.setAddress(new Address("500 Linden Street", "Fort Collins", "CO", "80526"));

        return person;
    }

}
