/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner;

import financeplanner.controller.*;
import financeplanner.model.Budget;
import financeplanner.model.Transaction;
import financeplanner.model.User;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 * @author Steven Burns
 * @author Brad Caviston
 * @author Ardjen Lane
 * @author Briley Marchetti
 * 
 * FinancePlanner acts as the master controller. When run, loads the main stage
 * and the dashboard. It is responsible for loading other windows and their 
 * controllers
 */
public class FinancePlanner extends Application
{
    @FXML BorderPane borderPane; //Reference to main stage layout
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    private User user;
    private DashController dashControl;
    private BudgetViewController budgetControl;
    private TransactionViewController transactionControl;
    private HistoryController historyControl;
    private LoginViewController loginControl;
    
    private TransactionHandler tHandler;
    private BudgetHandler bHandler;
    
    
    /*
    Loads the root layout and the dashboard view.
    Finds user's dimension and fits app to screen. 
    */
    @Override
    public void start(Stage primaryStage) throws SQLException
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Finance Planner");
        
        tHandler = new TransactionHandler();
        //bHandler = new BudgetHandler(this);
        
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            //Adjust to user screen
            //Screen userScreen = Screen.getPrimary();
            //Rectangle2D bounds = userScreen.getVisualBounds();
            //primaryStage.setX(bounds.getMinX());
            //primaryStage.setY(bounds.getMinY());
            //primaryStage.setWidth(bounds.getWidth());
            //primaryStage.setHeight(bounds.getHeight());
            
            primaryStage.show();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        showLoginWindow();
    }
    
    /*
    Loads the login view and its controller
    */
    public void showLoginWindow()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/LoginView.fxml"));
            AnchorPane loginWindow = (AnchorPane)loader.load();
            rootLayout.setCenter(loginWindow);
            
            LoginViewController controller = loader.getController();
            controller.initialize(this);
            loginControl = controller;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    /*
    Loads the dashboard view and its controller
    */
    public void showDashWindow() throws SQLException
    {
        try
        {
            bHandler = new BudgetHandler(this);
            
            removeWindows();
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/Dash.fxml"));
            AnchorPane dashWindow = (AnchorPane)loader.load();
            rootLayout.setCenter(dashWindow);
            
            DashController controller = loader.getController();
            controller.initialize(this);
            dashControl = controller;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    /*
    Loads view for saving transactions and its controller
    */
    public void showTransactionWindow()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/TransactionView.fxml"));
            AnchorPane transactionWindow = (AnchorPane)loader.load();
            rootLayout.setLeft(transactionWindow);
            
            TransactionViewController controller = loader.getController();
            controller.initialize(this);
            transactionControl = controller;
            primaryStage.setMinWidth(900);
            primaryStage.setMaxWidth(900);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    /*
    Loads view for saving transactions and its controller
    */
    public void showTransactionWindow(Transaction theTransaction)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/TransactionView.fxml"));
            AnchorPane transactionWindow = (AnchorPane)loader.load();
            rootLayout.setLeft(transactionWindow);
            
            TransactionViewController controller = loader.getController();
            controller.initialize(this, theTransaction);
            transactionControl = controller;
            primaryStage.setMinWidth(900);
            primaryStage.setMaxWidth(900);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    /*
    Loads view for saving budgets and its controller
    */
    public void showBudgetWindow()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/BudgetView.fxml"));
            AnchorPane budgetWindow = (AnchorPane)loader.load();
            rootLayout.setLeft(budgetWindow);
            
            BudgetViewController controller = loader.getController();
            controller.initialize(this);
            budgetControl = controller;
            primaryStage.setMinWidth(900);
            primaryStage.setMaxWidth(900);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    public void showBudgetWindow(Budget theBudget)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/BudgetView.fxml"));
            AnchorPane budgetWindow = (AnchorPane)loader.load();
            rootLayout.setLeft(budgetWindow);
            
            BudgetViewController controller = loader.getController();
            controller.initialize(this, theBudget);
            budgetControl = controller;
            primaryStage.setMinWidth(900);
            primaryStage.setMaxWidth(900);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    /*
    Loads view for saving budgets and its controller
    */
    public void showHistoryWindow()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/History.fxml"));
            AnchorPane historyWindow = (AnchorPane)loader.load();
            rootLayout.setCenter(historyWindow);
            
            HistoryController controller = loader.getController();
            controller.initialize(this);
            historyControl = controller;
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    /*
     * Pops up a window with message
     * 
     */
    public void showMessageWindow(String message)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/MessageWindow.fxml"));
            BorderPane pane = (BorderPane)loader.load();
            Stage popupStage = new Stage();
              popupStage.setTitle("Message");
              popupStage.initModality(Modality.WINDOW_MODAL);
              popupStage.initOwner(primaryStage);
            Scene scene = new Scene(pane);
            popupStage.setScene(scene);
            
            MessageWindowController controller = loader.getController();
            controller.setPopupStage(popupStage);
            controller.setApp(this);
            controller.setMessage(message);
            popupStage.showAndWait();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    /*
    Removes all windows except the center layout
    */
    public void removeWindows()
    {
        rootLayout.setLeft(null);
        rootLayout.setRight(null);
        rootLayout.setTop(null);
        rootLayout.setBottom(null);
    }
    
    public void resizeWindow(int width, int height)
    {
        this.primaryStage.setMinWidth(width);
        this.primaryStage.setMinHeight(height);
    }
    
    public void setUser(User user){this.user = user;}
    
    public User getUser(){return user;}
    public BorderPane getRootLayout(){return rootLayout;}
    public TransactionHandler getTransactionHandler(){return tHandler;}
    public BudgetHandler getBudgetHandler(){return bHandler;}
    public TransactionViewController getTransactionControl(){return transactionControl;}
    public BudgetViewController getBudgetControl(){return budgetControl;}
    public DashController getDashControl(){return dashControl;}
    public Stage getPrimaryStage(){return primaryStage;}
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
