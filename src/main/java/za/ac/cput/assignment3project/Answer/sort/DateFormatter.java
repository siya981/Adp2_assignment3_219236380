/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project.Answer.sort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Siyathandaza Mqhamane 219236380
 */
public class DateFormatter {
    //format date
    public static String formatDate(String date) {

        DateTimeFormatter stringDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, stringDateFormatter);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDateString = localDate.format(formatter);

        return formattedDateString;
    }

    
}
