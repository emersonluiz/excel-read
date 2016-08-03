package br.com.emerson;

import java.io.File;
import java.util.List;

import br.com.emerson.model.Person;
import br.com.emerson.util.ExcelRead;

public class Application {

    public static void main(String[] args) {

        ExcelRead excelXLSX = new ExcelRead(new File("src/main/resources/persons.xlsx"));
        List<Person> listXLSX = excelXLSX.read();

        for (Person person : listXLSX) {
            System.out.printf("Name: %s, Age: %d, Career: %s \n", person.getName(), person.getAge(), person.getCareer());
        }

        System.out.println("-------------------------------------------------");

        ExcelRead excelXLS = new ExcelRead(new File("src/main/resources/persons.xls"));
        List<Person> listXLS = excelXLS.read();

        for (Person person : listXLS) {
            System.out.printf("Name: %s, Age: %d, Career: %s \n", person.getName(), person.getAge(), person.getCareer());
        }

    }

}
