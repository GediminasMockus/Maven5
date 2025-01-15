package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("json!");

        Person person1 = new Person("Jonas",25,"jonasjonaitis@gmail.com");
        Person person2 = new Person("Antanas",30,"antanasantanaitis@gmail.com");
        Person person3 = new Person("Petras",45,"petraspetraitis@gmail.com");
        Person[] office ={person1,person2,person3};


        Company company = new Company("Splius","Tilzes g. 52","Siauliai");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));

        File outputJson = new File("src/main/java/org/example/outputJson.json");
        objectMapper.writeValue(outputJson, office);

        File input = new File("src/main/java/org/example/inputJson.json");

        if (!input.exists() || input.length() == 0) {
            System.out.println("Failas neegzistuoja arba yra tuščias. Įrašome numatytąjį turinį.");
            objectMapper.writeValue(input, office);
        }

        try {
            Company companyFromJson = objectMapper.readValue(input, Company.class);
            System.out.println("Nuskaityti duomenys: " + companyFromJson);
        } catch (IOException e) {
            System.err.println("Klaida nuskaitant failą: " + e.getMessage());
        }



    }

}