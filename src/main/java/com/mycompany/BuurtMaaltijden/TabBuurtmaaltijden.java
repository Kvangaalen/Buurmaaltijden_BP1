package com.mycompany.BuurtMaaltijden;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class TabBuurtmaaltijden {

    public Button herladenBTN;
    public Button toonMaaltijdBTN;
    public Button terugbuurtmaaltijdbtn;
    public BorderPane borderPaneBuurtmaaltijden;
    public BorderPane borderPaneDetailsbuurtmaaltijden;
    public ButtonBar buttonBar;
    public AnchorPane newBuurtBewoners;
    public Label label;
    public Label labe2;
    public ListView<Maaltijden> overzichtMaaltijden;

    public TabBuurtmaaltijden(AnchorPane AnchorPanBuurtmaaltijden, Buurtbewoners bewoner) throws SQLException {
        {
            borderPaneBuurtmaaltijden = new BorderPane();
            overzichtMaaltijden = new ListView();
            buttonBar = new ButtonBar();
            toonMaaltijdBTN = new Button();
            label = new Label();
            borderPaneDetailsbuurtmaaltijden = new BorderPane();
            terugbuurtmaaltijdbtn = new Button();
            labe2 = new Label();
            herladenBTN = new Button();

            AnchorPane.setBottomAnchor(borderPaneBuurtmaaltijden, 0.0);
            AnchorPane.setLeftAnchor(borderPaneBuurtmaaltijden, 0.0);
            AnchorPane.setRightAnchor(borderPaneBuurtmaaltijden, 0.0);
            AnchorPane.setTopAnchor(borderPaneBuurtmaaltijden, 0.0);
            borderPaneBuurtmaaltijden.setStyle("-fx-background-color : #ffffff;");
            borderPaneBuurtmaaltijden.setLayoutX(14.0);
            borderPaneBuurtmaaltijden.setPrefHeight(448.0);
            borderPaneBuurtmaaltijden.setPrefWidth(687.0);
            borderPaneBuurtmaaltijden.setAlignment(overzichtMaaltijden, javafx.geometry.Pos.CENTER);
            overzichtMaaltijden.setPrefHeight(225.0);
            overzichtMaaltijden.setPrefWidth(687.0);
            borderPaneBuurtmaaltijden.setCenter(overzichtMaaltijden);

            borderPaneBuurtmaaltijden.setAlignment(buttonBar, javafx.geometry.Pos.CENTER);
            buttonBar.setPrefHeight(82.0);
            buttonBar.setPrefWidth(687.0);
            herladenBTN.setMnemonicParsing(false);
            herladenBTN.setText("update-list");
            toonMaaltijdBTN.setMnemonicParsing(false);
            toonMaaltijdBTN.setText("Toon-details");
            borderPaneBuurtmaaltijden.setBottom(buttonBar);
            borderPaneBuurtmaaltijden.setMargin(overzichtMaaltijden, new Insets(0.0, 20.0, 0.0, 20.0));
            borderPaneBuurtmaaltijden.setAlignment(label, javafx.geometry.Pos.CENTER);
            label.setAlignment(javafx.geometry.Pos.CENTER);
            label.setPrefHeight(76.0);
            label.setPrefWidth(499.0);
            label.setText("Geplande maaltijden");

            label.setFont(new Font(48.0));
            borderPaneBuurtmaaltijden.setTop(label);
            buttonBar.setPadding(new Insets(0.0, 20.0, 0.0, 0.0));
            buttonBar.getButtons().addAll(herladenBTN,toonMaaltijdBTN);
            toonMaaltijdBTN.setStyle("-fx-background-color : #89cff0;");
            labe2.setText("Details buurtmaaltijd");
            borderPaneBuurtmaaltijden.setStyle("-fx-background-color : #d7d7d7;");
            borderPaneDetailsbuurtmaaltijden.setStyle("-fx-background-color : #d7d7d7;");
            borderPaneDetailsbuurtmaaltijden.setVisible(false);
            toonMaaltijdBTN.disableProperty().bind(overzichtMaaltijden.getSelectionModel().selectedItemProperty().isNull());
            Methods.toonbuurtmaaltijd(overzichtMaaltijden);

            // toevoegen aan de root class
            AnchorPanBuurtmaaltijden.getChildren().addAll(borderPaneBuurtmaaltijden, borderPaneDetailsbuurtmaaltijden);
            // knop toon maaltijd.
            toonMaaltijdBTN.setOnAction((ActionEvent event) -> {
                // roep methode voor toevoegen van maaltijden
                Maaltijden maaltijden = overzichtMaaltijden.getSelectionModel().getSelectedItem();

                try {
                    new TabMaaltijdOverzicht(borderPaneDetailsbuurtmaaltijden, borderPaneBuurtmaaltijden, maaltijden, bewoner);
                } catch (SQLException ex) {
                    Logger.getLogger(TabBuurtmaaltijden.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                Methods.toonmaaltijden(borderPaneDetailsbuurtmaaltijden, borderPaneBuurtmaaltijden);
            });

            herladenBTN.setOnAction((ActionEvent event) -> {
                // roep methode voor toevoegen van maaltijden
               overzichtMaaltijden.getItems().clear();
               overzichtMaaltijden.getSelectionModel().clearSelection();
                Methods.toonbuurtmaaltijd(overzichtMaaltijden);
            });

        }
    }
}
