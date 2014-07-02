package com.dev9.web.controller;

import com.dev9.service.ApplicationNameService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HomeControllerTest {

    private HomeController controller;

    @Before
    public void setup() {
        controller = new HomeController();
        controller.appService = mock(ApplicationNameService.class);
    }

    @Test
    public void testShowHomePage() throws Exception {
        when(controller.appService.getName()).thenReturn("ApplicationName");
        when(controller.appService.getVersion()).thenReturn("1");

        Model model = new ExtendedModelMap();
        assertThat(controller.showHomePage(model), is("home/home"));
        Map<String, Object> stringObjectMap = model.asMap();

        assertThat(stringObjectMap.containsKey("appName"), is(true));
        assertThat(stringObjectMap.containsKey("appVersion"), is(true));
    }
}
