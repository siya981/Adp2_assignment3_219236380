/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project.Answer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import za.ac.cput.assignment3project.Answer.sort.NameSort;
import za.ac.cput.assignment3project.Supplier;

/**
 *
 * @author Siyathandaza Mqhamane 219236380
 */
public class SupplierImplementation {
     //sort suppliers 
    public ArrayList<Supplier> sortSuppliers(ArrayList<Supplier> suppliers) {
        suppliers.sort(new NameSort());
        return suppliers;

    }

    //print details to file
    public void writeToFile(ArrayList<Supplier> suppliers) {
            try {

            // open the file
            FileWriter fw = new FileWriter("supplierOutFile.txt", false);
            PrintWriter out = new PrintWriter(fw);

            String spacing = "%-5s %-20s %-10s %-10s";
            // heading
            out.println("================================== SUPPLIERS ==============================");
             out.println(String.format(spacing,"ID","Name", "Prod Type", "Description"));
            out.println("===========================================================================");
           for (int i=0; i< suppliers.size(); i++) {
               Supplier sup = suppliers.get(i);
                out.println(String.format(spacing,sup.getStHolderId(),sup.getName(), sup.getProductType(), sup.getProductDescription()));
        
           }

            out.println("\n");
           
            // Close the file.
            out.close();
 

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
    
}
