package financeplanner.controller;

import financeplanner.FinancePlanner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class for general message windows
 *
 * @author Ardjen
 */
public class MessageWindowController
{    
    @FXML
    private Label message;
    
    @FXML
    private Button button;
    
    private Stage popupStage;
    private FinancePlanner app;

    /**
     * Called when controller is loaded. Initializes components.
     */
    public void initialize()
    {
        button.setDefaultButton(true);
    }

    /**
     * On cancel click, closes the window
     */
    @FXML
    private void handleCancel()
    {
        popupStage.close();
    }

    //Setters
    public void setPopupStage(Stage popupStage){this.popupStage = popupStage;}
    public void setApp(FinancePlanner app){this.app = app;}
    public void setMessage(String message){this.message.setText(message);}
    
}
