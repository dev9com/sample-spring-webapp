package com.dynacrongroup.web.controller;

import com.dynacrongroup.exception.AnotherKnownRuntimeException;
import com.dynacrongroup.exception.SimpleKnownRunTimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/home")
/**
 * Home Controller sample
 *
 * All Request to "/home" start here
 */
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    /**
     * No additional request value mapping, but forces to only GET requests
     *
     * @return String viewForInternalViewResolver
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage() {
        return "home/home";
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
