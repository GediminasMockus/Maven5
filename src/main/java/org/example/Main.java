package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Person person = new Person("Jonas", 25, "jonasjonaitis@gmail.com");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File result = new File("src/main/java/org/example/rezultatas.json");
        objectMapper.writeValue(result, person);

        try {
            Person personFromFile = objectMapper.readValue(result, Person.class);
            System.out.println("Nuskaityti duomenys: " + personFromFile);
        } catch (IOException e) {
            System.err.println("Klaida nuskaitant failą: " + e.getMessage());
        }

    }
}