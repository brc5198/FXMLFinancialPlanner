/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialPlanner;

/**
 *
 * @author bradcaviston
 */
public class Category {
    
    private String name;
    private String description;
    
    public Category(String newName, String newDescription) {
        name = newName;
        description = newDescription;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
}
