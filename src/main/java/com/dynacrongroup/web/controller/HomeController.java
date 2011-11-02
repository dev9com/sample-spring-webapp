package com.dynacrongroup.web.controller;

import com.dynacrongroup.exception.AnotherKnownRuntimeException;
import com.dynacrongroup.exception.SimpleKnownRunTimeException;
import com.dynacrongroup.service.ApplicationNameService;
import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/")
/**
 * Home Controller sample
 *
 * All Request to "/home" start here
 */
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    @VisibleForTesting
    ApplicationNameService appService;

    /**
     * No additional request value mapping, but forces to only GET requests
     *
     * @param model Model
     * @return String viewForInternalViewResolver
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(Model model) {
        model.addAttribute("appName", appService.getName());
        model.addAttribute("appVersion", appService.getVersion());
        return "home/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String redirectToHome() {
        return "redirect:/";
    }

    @RequestMapping(value = "/undecorated", method = RequestMethod.GET)
    public String undecoratedPage() {
        return "home/undecorated";
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String showPersonPage() {
        return "home/person";
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String throwException() {
        throw new SimpleKnownRunTimeException("This is to simulate a runtime exception");
    }

    @RequestMapping(value = "/exception-and-catch", method = RequestMethod.GET)
    public String throwExceptionAndCatchInController() {
        throw new AnotherKnownRuntimeException("This is to simulate a runtime exception that we will catch in our controller");
    }

    @ExceptionHandler(value = AnotherKnownRuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(AnotherKnownRuntimeException ex) {
        LOG.error("Caught our own exception", ex);
        return "errors/simpleRuntimeException";
    }

    @ExceptionHandler(value = SimpleKnownRunTimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleExceptionRunTime(SimpleKnownRunTimeException ex) {
        LOG.error("Caught our own exception", ex);
        return "errors/knownRuntimeException";
    }

}
