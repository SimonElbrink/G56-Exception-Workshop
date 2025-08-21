package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

    // TODO : Solve.
    public static void main(String[] args) {

        List<String> maleFirstNames = null;

        try {
            maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        List<String> lastNames = CSVReader_Writer.getLastNames();


        NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);

        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

        try {
            nameService.addLastName("stefan");
        } catch (DuplicateNameException e) {
            throw new RuntimeException(e);
        }

    }

}
