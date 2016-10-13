package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Budget;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
 * 
 * Controller for BudgetView Window
 */
public class BudgetViewController
{

    @FXML TextField amountInput;
    @FXML TextField locationInput;
    @FXML DatePicker startInput;
    @FXML DatePicker endInput;
    @FXML Button saveButton;
    @FXML Button cancelButton;
    
    private FinancePlanner app;
    
    private BudgetHandler budgetHandler;

    /**
     * Initializes the controller class.
     */
    public void initialize()
    {
        
    }
    
    /*
    Handles save button
    */
    @FXML
    public void handleSaveButton()
    {
        System.out.println("Save called");
        app.removeWindows();
    }
    
    /*
    Handles cancel button
    */
    @FXML
    public void handleCancelButton()
    {
        System.out.println("Cancel called");
        app.removeWindows();
    }
    
    /*
    From BudgetHandler, creates a new budget
    */
    public Budget requestNewBudget()
    {
        Budget newBudget = null;
        
        return newBudget;
    }

    public void setApp(FinancePlanner app)
    {
        this.app = app;
    }
    
}
