package com.dynacrongroup.web.controller;

import com.dynacrongroup.web.model.Address;
import com.dynacrongroup.web.model.Person;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AjaxControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testShowOffJackson() throws Exception {
        Person firstPerson = new Person();
        firstPerson.setFirstName("Mike");
        firstPerson.setLastName("Ensor");

        Address address = new Address("address1", "City", "state", "88888");
//        firstPerson.setAddress(address);

        String serialized = mapper.writeValueAsString(firstPerson);
        assertThat(serialized, notNullValue());

        Person person = mapper.readValue(serialized, Person.class);
        assertThat(person.getFirstName(), is(firstPerson.getFirstName()));
    }
}
