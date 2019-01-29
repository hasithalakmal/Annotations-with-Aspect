package com.smile24es.sample.web;

import com.smile24es.sample.service.ModernGreetingService;
import com.smile24es.sample.service.TraditionalGreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller class for testing
 * <p>
 * Created by hasithag
 * on 1/12/19.
 */
@RestController
public class SmileGreetingController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmileGreetingController.class);


    @Autowired
    private TraditionalGreetingService sampleService;

    @Autowired
    private ModernGreetingService modernGreetingService;

    /**
     * The endpoint to demonstrate traditional greeting
     *
     * @return
     * @throws
     */
    @GetMapping(value = "smile24/service/traditional/greetings", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String traditionalGreeting() {

        LOGGER.info("Received request for traditional greeting");
        return sampleService.greetingWithoutName();
    }

    /**
     * The endpoint to demonstrate traditional greeting with name
     *
     * @return
     * @throws
     */
    @GetMapping(value = "smile24/service/traditional/greetings/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String traditionalGreetingWithName(@PathVariable String name) {

        LOGGER.info("Received request for traditional greeting with user name [{}]", name);
        return sampleService.greetingWithName(name);
    }

    /**
     * The endpoint to demonstrate modern greeting
     *
     * @return
     * @throws
     */
    @GetMapping(value = "smile24/service/modern/greetings", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String modernGreeting() {

        LOGGER.info("Received request for modern greeting");
        return modernGreetingService.greetingWithoutName();
    }

    /**
     * The endpoint to demonstrate modern greeting with name
     *
     * @return
     * @throws
     */
    @GetMapping(value = "smile24/service/modern/greetings/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String modernGreetingWithName(@PathVariable String name) {

        LOGGER.info("Received request for modern greeting with user name [{}]", name);
        return modernGreetingService.greetingWithName(name);
    }

    /**
     * The endpoint to demonstrate modern greeting with name
     *
     * @return
     * @throws
     */
    @GetMapping(value = "smile24/service/modern/greetings/{firstName}/{secondName}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String modernGreetingWithFullName(@PathVariable String firstName, @PathVariable String secondName) {

        LOGGER.info("Received request for modern greeting with user first name [{}] and second name [{}]", firstName, secondName);
        return modernGreetingService.greetingWithFullName(firstName, secondName);
    }


}
