package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
    public String companyName;
    public String adress;
    public String city;

    public Company() {
    }

    public Company(String companyName, String adress, String city) {
        this.companyName = companyName;
        this.adress = adress;
        this.city = city;
    }

    public Company(String splius, String s, String siauliai, Person[] office) {
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}


