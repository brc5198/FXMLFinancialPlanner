/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeplanner;

import financeplanner.controller.BudgetViewController;
import financeplanner.controller.DashController;
import financeplanner.controller.TransactionViewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 *
 * @author Ardjen
 */
public class FinancePlanner extends Application
{
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) throws Exception
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
        //showTransactionWindow();
        //showBudgetWindow();
    }
    
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
    
    public BorderPane getRootLayout(){return rootLayout;}
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
