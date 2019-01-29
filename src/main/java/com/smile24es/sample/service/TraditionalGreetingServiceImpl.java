package com.smile24es.sample.service;

import com.smile24es.sample.beans.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TraditionalGreetingServiceImpl implements TraditionalGreetingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraditionalGreetingServiceImpl.class);

    @Override
    public String greetingWithoutName() {
        LOGGER.info("Start executing greetingWithoutName");
        String greeting = Constants.GREETING;
        LOGGER.info("Exit from method greetingWithoutName");
        return greeting;
    }

    @Override
    public String greetingWithName(String name) {
        LOGGER.info("Start executing greetingWithName. Parameters [{}]", name);
        String greeting = Constants.GREETING + " " + name;
        LOGGER.info("Exit from method greetingWithName. Parameters [{}]", name);
        return greeting;
    }
}
