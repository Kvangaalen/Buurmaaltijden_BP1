// dit document is voor alle tabpane
package com.mycompany.BuurtMaaltijden;

import java.sql.SQLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GuiTabPane {

    public GuiTabPane(StackPane root, Buurtbewoners bewoner) throws SQLException {
        StackPane stackPane = new StackPane();
        Text text = new Text();
        TabPane tabPane = new TabPane();
        // tabs........
        Tab tabMaaltijden = new Tab();
        Tab tabMijnMaaltijden = new Tab();
        Tab tabMijnGegevens = new Tab();
        Tab tabBuurtbewoners = new Tab();
        // tabs pane.........
        AnchorPane AnchorPanBuurtmaaltijden = new AnchorPane();
        AnchorPane AnchorPaneMijnMaaltijden = new AnchorPane();
        BorderPane AnchorPaneMijnGegevens = new BorderPane();
        AnchorPane BorderpaneBuurtbewoners = new AnchorPane();
        stackPane.setStyle("-fx-background-color : #89cff0;");
        // stackpane header text
        stackPane.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        stackPane.setPrefHeight(85.0);
        stackPane.setPrefWidth(1200.0);
        stackPane.setLayoutX(63.0);
        stackPane.setLayoutY(14.0);
        stackPane.setPrefWidth(1200.0);
        // header text
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Buurtmaaltijd");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(731.2943698323116);
        text.setFont(new Font("System Bold Italic", 60.0));
        // tabpane
        tabPane.setLayoutY(78.0);
        tabPane.setPrefHeight(522.0);
        tabPane.setPrefWidth(1200.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setPadding(new Insets(80.0, 0.0, 0.0, 0.0));

        tabMaaltijden.setText("Geplande Maaltijden");
        new TabBuurtmaaltijden(AnchorPanBuurtmaaltijden, bewoner);
        tabMaaltijden.setContent(AnchorPanBuurtmaaltijden);

        tabMijnMaaltijden.setText("Mijn maaltijden");
        new TabMijnMaaltijden(AnchorPaneMijnMaaltijden, bewoner);
        tabMijnMaaltijden.setContent(AnchorPaneMijnMaaltijden);

        tabBuurtbewoners.setText("Buurtbewoners");
        new TabBuurtbewoners(BorderpaneBuurtbewoners);
        tabBuurtbewoners.setContent(BorderpaneBuurtbewoners);

        tabMijnGegevens.setText("Mijn gegevens");
        new TabMijnGegevens(AnchorPaneMijnGegevens, bewoner);
        tabMijnGegevens.setContent(AnchorPaneMijnGegevens);

        tabPane.getSelectionModel().getSelectedItem();
        System.out.println(tabPane.getSelectionModel().getSelectedItem());
        // print geselecteerde buurtbewoner
        System.out.println("Buurtbewoner " + bewoner.getNaam());

        // toevoegen aan de Child class 
        stackPane.getChildren().add(text);
        tabPane.getTabs().addAll(tabMaaltijden, tabBuurtbewoners, tabMijnMaaltijden, tabMijnGegevens);

        // toevoegen aan de root class
        root.getChildren().addAll(stackPane, tabPane);

        tabMijnGegevens.setOnSelectionChanged(event -> {
            if (tabMijnGegevens.isSelected()) {
                System.out.println("Tab is Selected");
                //Do stuff here
            }
        });
        
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
                if (newTab.equals(tabMijnGegevens)) {
                    System.out.print("test"+tabMijnGegevens.isSelected());
                }
            }
        });
    }

}
