package com.dynacrongroup.web.controller;

import com.dynacrongroup.web.model.Address;
import com.dynacrongroup.web.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/ajax", headers = {"Accept=application/json,application/xml"})
public class AjaxController {

    private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseBody
    public Person showOffJackson(@RequestBody Person person) {
        logger.error("Received {} {}", person.getFirstName(), person.getLastName());
        logger.error("No Address was included");

        person.setAddress(new Address("500 Linden Street", "Fort Collins", "CO", "80526"));

        return person;
    }

}
