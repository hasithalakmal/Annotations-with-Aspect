package com.smile24es.sample.service;

public interface ModernGreetingService {

    String greetingWithoutName();

    String greetingWithName(String name);

    String greetingWithFullName(String firstName, String secondName);
}
