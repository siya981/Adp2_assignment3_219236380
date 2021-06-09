/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project.Answer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import za.ac.cput.assignment3project.Customer;
import za.ac.cput.assignment3project.Supplier;

/**
 *
 * @author Siyathandaza Mqhamane 219236380
 */
public class Main {

    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Supplier> suppliers = new ArrayList<>();

    //read inputFile
    public List<Object> readFileContents(String inputFile) {
        ObjectInputStream objectInputStream = null;
        List<Object> objects = new ArrayList();
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            objectInputStream = new ObjectInputStream(bufferedInputStream);
            while (true) {

                objects.add(objectInputStream.readObject());
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException ioException) {
                System.out.println(ioException);
            }
        }

        return objects;

    }

    //store values
    public void storeObjects(List<Object> objects) {
        for (Object object : objects) {
            if (object instanceof Customer) {
                customers.add((Customer) object);
            } else {
                suppliers.add((Supplier) object);
            }

        }
    }
    
    public void runSolution(){
        //print customers list to file
        CustomerImplementation  customerImpl = new CustomerImplementation(); 
        ArrayList<Customer> customerList = customerImpl.sortCustomers(customers);
        customerImpl.writeToFile(customerList);
        
          SupplierImplementation  supplierImpl = new SupplierImplementation(); 
        ArrayList<Supplier> supplierList = supplierImpl.sortSuppliers(suppliers);
        supplierImpl.writeToFile(supplierList);
       
    }

    public static void main(String[] args) {

        Main main = new Main();
        List<Object> objects = new ArrayList<>();

        objects = main.readFileContents("stakeholder.ser");
        main.storeObjects(objects);
        
        main.runSolution();
        
        

    }
}
