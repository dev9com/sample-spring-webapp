package com.dynacrongroup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
/**
 * Home Controller sample
 *
 * All Request to "/home" start here
 */
public class HomeController {

    /**
     * No additional request value mapping, but forces to only GET requests
     * @return String viewForInternalViewResolver
     */
    @RequestMapping(method= RequestMethod.GET)
    public String showHomePage() {
        return "home/home";
    }
}
