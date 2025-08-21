package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

    public static void main(String[] args) {

        List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        List<String> lastNames = null;

        try {
            lastNames = CSVReader_Writer.getLastNames();
        } catch (IOException e) {
            System.out.println("Could not read last names: " + e.getMessage());;
        }


        NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);

        // Female name:
        try {
            nameService.addFemaleFirstName("Linda");
            System.out.println("Successfully added female name: Linda");
        } catch (DuplicateNameException e) {
            System.out.println("Female name already exists: " + e.getMessage());
        }

        // Male name:
        try {
            nameService.addMaleFirstName("Bertil");
            System.out.println("Successfully added male name: Bertil");
        } catch (DuplicateNameException e) {
            System.out.println("Male name already exists: " + e.getMessage());
        }

        // Last name: Karlsson
        try {
            nameService.addLastName("Sigurdsson");
            System.out.println("Successfully added last name: Sigurdsson");
        } catch (DuplicateNameException e) {
            System.out.println("Last name already exists: " + e.getMessage());
        }

        // Last name: Wallenberg
        try {
            nameService.addLastName("Wallenberg");
            System.out.println("Successfully added last name: Wallenberg");
        } catch (DuplicateNameException e) {
            System.out.println("Last name already exists: " + e.getMessage());
        }

        // Test: generate random person
        Person test = nameService.getNewRandomPerson();
        System.out.println("Generated random person: " + test);

    }

}
