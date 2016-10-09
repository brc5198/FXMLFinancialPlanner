/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bradcaviston
 */
public class Transaction {
    
    private final double amount;
    private final LocalDate timeStamp;
    private final String location;
    
    public Transaction(double newAmount, LocalDate newTimeStamp, String newLocation) {
        amount = newAmount;
        timeStamp = newTimeStamp;
        location = newLocation;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public StringProperty getAmountProperty() {
        StringProperty returnedString = new SimpleStringProperty(String.valueOf(amount));
        
        return returnedString;
    }
    
    public LocalDate getTimeStamp() {
        return timeStamp;
    }
    
    public StringProperty getTimeStampProperty() {
        StringProperty returnedString = new SimpleStringProperty(timeStamp.toString());
        
        return returnedString;
    }
    
    public String getLocation() {
        return location;
    }
    
    public StringProperty getLocationProperty() {
        StringProperty returnedString = new SimpleStringProperty(location);
        
        return returnedString;
    }
    
}
