// dit document is voor opstarten van applictie
package com.mycompany.BuurtMaaltijden;

import java.sql.Connection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.stage.Stage;


public class Main extends Application {
      public  Connection con = null;
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1200 , 800);
        // open GuiAanmelden
        new GuiAanmelden(root, primaryStage);
        root.setMaxHeight(USE_PREF_SIZE);
        root.setMaxWidth(USE_PREF_SIZE);
        root.setMinHeight(USE_PREF_SIZE);
        root.setMinWidth(USE_PREF_SIZE);
        primaryStage.setScene(scene);
        //gebruiker kan scherm niet aanpassen...
        //primaryStage.setResizable(false);
        primaryStage.setTitle("Buurtmaaltijd");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
