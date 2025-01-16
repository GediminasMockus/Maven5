package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Person> persons = new ArrayList<>();

        Person person = new Person("Jonas", 25, "jonasjonaitis@gmail.com");
        Person person1 = new Person("Petras", 30, "petraspetraitis@gmail.com");
        Person person2 = new Person("Antanas", 45, "antanasantanaitis@gmail.com");

        persons.add(person);
        persons.add(person1);
        persons.add(person2);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File result = new File("src/main/java/org/example/persons.json");
        objectMapper.writeValue(result, persons);

        try {
            List<Person> personFromFile = objectMapper.readValue(result, new TypeReference<List<Person>>() {});
            System.out.println("Nuskaityti duomenys: " + personFromFile);
        } catch (IOException e) {
            System.err.println("Klaida nuskaitant failą: " + e.getMessage());
        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonToString = mapper.writeValueAsString(persons);
        System.out.println(persons);

        List<Person> docToList = mapper.readValue(jsonToString, new TypeReference<List<Person>>() {
        });
    }
}