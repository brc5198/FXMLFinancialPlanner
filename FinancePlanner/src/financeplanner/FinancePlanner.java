/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner;

import financeplanner.controller.BudgetHandler;
import financeplanner.controller.BudgetViewController;
import financeplanner.controller.DashController;
import financeplanner.controller.TransactionHandler;
import financeplanner.controller.TransactionViewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
    
    private TransactionHandler tHandler = new TransactionHandler();
    private BudgetHandler bHandler = new BudgetHandler();
    
    
    /*
    Loads the root layout and the dashboard view.
    Finds user's dimension and fits app to screen. 
    */
    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Finance Planner");
        
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            //Adjust to user screen
            Screen userScreen = Screen.getPrimary();
            Rectangle2D bounds = userScreen.getVisualBounds();
            primaryStage.setX(bounds.getMinX());
            primaryStage.setY(bounds.getMinY());
            primaryStage.setWidth(bounds.getWidth());
            primaryStage.setHeight(bounds.getHeight());
            
            primaryStage.show();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        showDashWindow();
    }
    
    /*
    Loads the dashboard view and its controller
    */
    public void showDashWindow()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(FinancePlanner.class.getResource("view/Dash.fxml"));
            AnchorPane dashWindow = (AnchorPane)loader.load();
            rootLayout.setCenter(dashWindow);
            
            DashController controller = loader.getController();
            controller.setApp(this);
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
            controller.setApp(this);
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
            controller.setApp(this);
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
    
    public BorderPane getRootLayout(){return rootLayout;}
    public TransactionHandler getTransactionHandler(){return tHandler;}
    public BudgetHandler getBudgetHandler(){return bHandler;}
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
