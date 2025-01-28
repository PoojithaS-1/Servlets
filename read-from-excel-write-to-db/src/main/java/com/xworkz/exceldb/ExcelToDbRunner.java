package com.xworkz.exceldb;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelToDbRunner {

    public static void main(String[] args) throws Exception {
        // Step 1: Create EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("poojitha");
        EntityManager em = emf.createEntityManager();

        // Step 2: Read the Excel file
        try (FileInputStream file = new FileInputStream(new File("C:/Users/LENOVO/Downloads/student1.xlsx"))) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Step 3: Iterate through rows and read data
            em.getTransaction().begin();
            for (Row row : sheet) {
                // Skip the header row
                if (row.getRowNum() == 0) {
                    continue;
                }

                Cell rollNoCell = row.getCell(0);
                Cell nameCell = row.getCell(1);

                if (rollNoCell != null && nameCell != null) {
                    int rollNo = (int) rollNoCell.getNumericCellValue();
                    String name = nameCell.getStringCellValue();

                    // Step 4: Create a new Student object and persist to database
                    Student1 student1 = new Student1();
                    student1.setRollNo(rollNo);
                    student1.setName(name);
                    em.persist(student1);
                }
            }

            // Commit the transaction
            em.getTransaction().commit();
        } catch (IOException e) {
            // Handle exception
            System.err.println("Error reading Excel file: " + e.getMessage());
        } finally {
            // Close EntityManager and EntityManagerFactory
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }

        // Display success message
        System.out.println("Data from Excel file written to database successfully");
    }
}
