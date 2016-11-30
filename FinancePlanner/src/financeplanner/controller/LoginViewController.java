package financeplanner.controller;

import financeplanner.FinancePlanner;
import financeplanner.model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ardjen
 */
public class LoginViewController
{
    private FinancePlanner app;

    @FXML Button returnLogin, newLogin;
    @FXML TextField firstNameInput, lastNameInput;
    @FXML ChoiceBox userSelect;
    
    ArrayList<User> users;
    
    private Connector conn;
    
    /**
     * Initializes the controller class.
     */
    public void initialize(FinancePlanner app) 
    {
        this.app = app;
        //*******FOR TESTING**********************
        users = new ArrayList<User>();
        User user = new User();
          user.setFirstName("Test");
          user.setLastName("User");
        users.add(user);
        //****************************************
        
        
        try
        {
            conn = new Connector();
            users.addAll(conn.populateUserArrayList());
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            // TODO Inform user of error
        }
        
        setupChoiceBox();
    }    
    
    @FXML
    private void handleNewLogin() throws SQLException
    {
        if(checkInput())
        {
            User user = new User();
              user.setFirstName(firstNameInput.getText());
              user.setLastName(lastNameInput.getText());
            
            //Write user into database
            
            app.setUser(user);
            conn.addNewUser(user);
            app.showDashWindow();
        }
        else
        {
            //TODO inform user of incorrect fields
            System.out.println("One or more fields are incorrect");
        }
    }
    
    @FXML
    private void handleReturnLogin()
    {
        int index = userSelect.getSelectionModel().getSelectedIndex();
        User user = users.get(index);
        app.setUser(user);
        app.showDashWindow();
    }
    
    private boolean checkInput()
    {
        boolean correct = true;
        
        if(firstNameInput.getText() == null || firstNameInput.getText().equals("")){correct = false;}
        if(lastNameInput.getText() == null || lastNameInput.getText().equals(""));
        
        return correct;
    }
    
    private void setupChoiceBox()
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        
        if(!users.isEmpty())
        {
            for(int i = 0; i < users.size(); i++)
            {
                items.add(users.get(i).getFirstName()+" "+users.get(i).getLastName());
            }
        }
        else
        {
            items.add("No Existing Users");
        }
        
        userSelect.setItems(items);
        userSelect.getSelectionModel().selectFirst();
    }
}
