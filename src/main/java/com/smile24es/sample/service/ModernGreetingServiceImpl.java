package com.smile24es.sample.service;

import com.smile24es.sample.Annotations.AutoLoggable;
import com.smile24es.sample.beans.common.Constants;
import org.springframework.stereotype.Service;

@Service
public class ModernGreetingServiceImpl implements ModernGreetingService {

    @AutoLoggable
    @Override
    public String greetingWithoutName() {
        return Constants.GREETING;
    }

    @AutoLoggable
    @Override
    public String greetingWithName(String name) {
        return Constants.GREETING + " " + name;
    }

    @AutoLoggable(isLogArgs = false, isLogExecutionTime = true)
    @Override
    public String greetingWithFullName(String firstName, String secondName) {
        return Constants.GREETING + " " + firstName + " " + secondName;
    }
}
