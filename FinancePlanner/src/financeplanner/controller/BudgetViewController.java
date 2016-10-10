package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.Budget;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ardjen
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
    
    @FXML
    public void handleSaveButton()
    {
        System.out.println("Save called");
        app.removeWindow();
    }
    
    @FXML
    public void handleCancelButton()
    {
        System.out.println("Cancel called");
        app.removeWindow();
    }
    
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
