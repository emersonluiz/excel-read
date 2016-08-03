package br.com.emerson.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.emerson.model.Person;

public class ExcelRead {

    File file;

    public ExcelRead(File file) {
        this.file = file;
    }

    private List<Person> getXLSX(FileInputStream fileInputStream) {
        List<Person> list = new ArrayList<Person>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Person person = new Person();
                list.add(person);

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            person.setName(cell.getStringCellValue());
                            break;
                        case 1:
                            Double age = cell.getNumericCellValue();
                            person.setAge(age.intValue());
                            break;
                        case 2:
                            person.setCareer(cell.getStringCellValue());
                            break;
                    }
                }
            }
            fileInputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private List<Person> getXLS(FileInputStream fileInputStream) {
        List<Person> list = new ArrayList<Person>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Person person = new Person();
                list.add(person);

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            person.setName(cell.getStringCellValue());
                            break;
                        case 1:
                            Double age = cell.getNumericCellValue();
                            person.setAge(age.intValue());
                            break;
                        case 2:
                            person.setCareer(cell.getStringCellValue());
                            break;
                    }
                }
            }
            fileInputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Person> read() {
        List<Person> list = new ArrayList<Person>();
        try {
            FileInputStream f = new FileInputStream(this.file);

            if (file.getName().contains(".xlsx")) {
                list = getXLSX(f);
            } else {
                list = getXLS(f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
