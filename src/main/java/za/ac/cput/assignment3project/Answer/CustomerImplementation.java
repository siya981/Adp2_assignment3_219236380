/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project.Answer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import za.ac.cput.assignment3project.Answer.sort.DateFormatter;
import za.ac.cput.assignment3project.Answer.sort.IdSort;
import za.ac.cput.assignment3project.Customer;
import za.ac.cput.assignment3project.Supplier;

/**
 *
 * @author Siyathandaza Mqhamane 219236380
 */
public class CustomerImplementation {
    
    //sort customers using the id
    public ArrayList<Customer> sortCustomers(ArrayList<Customer> customers) {
        customers.sort(new IdSort());
        return customers;

    }
    
     //get the age of the customer
    public int calculateAge(String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //convert String to LocalDate
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        return Period.between(birthDate, LocalDate.now()).getYears();

    }
    
     //write the Customer's Details to the text file
    public void writeToFile(ArrayList<Customer> customers) {
        try {

            // Open the file in append mode.
            FileWriter fw = new FileWriter("customerOutFile.txt", false);
            PrintWriter printWriter = new PrintWriter(fw);
            
            

            String formatStr = "%-10s %-15s %-15s %-15s %-15s";
            // Append the name of ocean to the file
            printWriter.println("================================== CUSTOMERS ==============================");
            printWriter.println(String.format(formatStr,"ID","Name", "Surname", "Date of birth", "Age"));
            printWriter.println("===========================================================================");
            
            
            for (int i=0; i< customers.size(); i++) {
              
               Customer customer = customers.get(i);
                System.out.println(customer.toString());
                 printWriter.println(String.format(formatStr,customer.getStHolderId(),customer.getFirstName(), customer.getSurName(),DateFormatter.formatDate(customer.getDateOfBirth()),calculateAge(customer.getDateOfBirth())));
               
        
           }
            printWriter.println("\n");
           
            printWriter.println("Number of customers who can rent:      "+ getCanRentNumber(customers) );
            printWriter.println("Number of customers who cannot rent:   "+ getCannotRentNumber(customers) );
            // Close the file.
            printWriter.close();
         

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    //calculate number of customers who can rent 
    public int getCanRentNumber(ArrayList<Customer> customers) {
        int count = 0;
        int i = 0;
        while ( i < customers.size()) {
            Customer customer = customers.get(i);
            if (customer.getCanRent() == true) {
                count++;
                
            }
            i++;
        }
        return count;
    }

    //get the number of customers who cannot rent 
    public int getCannotRentNumber(ArrayList<Customer> customers) {
        int count = 0;
        int i = 0;
        while ( i < customers.size()) {
            Customer customer = customers.get(i);
            if (customer.getCanRent() == false) {
                count++;
                
            }
            i++;
        }
        return count;
    }

}
