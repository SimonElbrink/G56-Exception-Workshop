package se.lexicon.exceptions.workshop;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        List<String> lastNames = null;
        try {
            lastNames = CSVReader_Writer.getLastNames();
        } catch (IOException e) {
            System.out.println("IOException: An error occurred while copying the file - " + e.getMessage());
        }


        NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);

        try {
            nameService.addFemaleFirstName("Lalita");
            nameService.addFemaleFirstName("Sylvia");
            nameService.addMaleFirstName("Mykyta");
            nameService.addMaleFirstName("Simon");
        } catch (DuplicateNameException e) {
            System.out.println("You can't add name: " + e.getMessage());
        }

            nameService.addLastName("Elbrink");
            nameService.addLastName("Xu");
            nameService.addLastName("Shadrin");
            nameService.addLastName("Shahi");



        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

    }

}
