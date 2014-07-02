package com.dev9.web.controller;

import com.dev9.web.model.Person;
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

        String serialized = mapper.writeValueAsString(firstPerson);
        assertThat(serialized, notNullValue());

        Person person = mapper.readValue(serialized, Person.class);
        assertThat(person.getFirstName(), is(firstPerson.getFirstName()));
    }


}
