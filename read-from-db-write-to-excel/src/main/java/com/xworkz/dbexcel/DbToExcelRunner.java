package com.xworkz.dbexcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DbToExcelRunner {

    // Main driver method
    public static void main(String[] args) throws Exception {
        // Step 1: Create EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("poojitha");
        EntityManager em = emf.createEntityManager();

        // Step 2: Execute a query to fetch data from the database
        Query query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();

        // Step 3: Create a workbook and spreadsheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("student");

        // Create header row
        XSSFRow headerRow = spreadsheet.createRow(0);
        XSSFCell cell;
        cell = headerRow.createCell(0);
        cell.setCellValue("RollNo");
        cell = headerRow.createCell(1);
        cell.setCellValue("Name");

        // Step 4: Populate the spreadsheet with data
        int rowIndex = 1;
        for (Student student : students) {
            XSSFRow row = spreadsheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(student.getRollNo());
            row.createCell(1).setCellValue(student.getName());
        }

        // Step 5: Write the workbook to a file
        try (FileOutputStream output = new FileOutputStream(new File("C:/Users/LENOVO/Downloads/student.xlsx"))) {
            workbook.write(output);
        } catch (IOException e) {
            // Handle exception
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            // Close workbook
            try {
                workbook.close();
            } catch (IOException e) {
                System.err.println("Error closing workbook: " + e.getMessage());
            }
        }

        // Close EntityManager and EntityManagerFactory
        em.close();
        emf.close();

        // Display success message
        System.out.println("student.xlsx written successfully");
    }
}
