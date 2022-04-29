package com.mycompany.BuurtMaaltijden;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class TabMaaltijdOverzicht {

    private ListView listView;
    Connection con = null;

    public TabMaaltijdOverzicht(BorderPane borderPaneDetailsbuurtmaaltijden, BorderPane borderPaneBuurtmaaltijden, Maaltijden maaltijden, Buurtbewoners bewooner) throws SQLException {

        // declareren  variabele
        Label label = new Label();
        ButtonBar buttonBar = new ButtonBar();
        Button terugOverzichtBTN = new Button();
        Button aanmeldenBTN = new Button();
        Button afmeldenBTN = new Button();
        GridPane gridPane = new GridPane();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        ColumnConstraints columnConstraints0 = new ColumnConstraints();
        RowConstraints rowConstraints = new RowConstraints();
        RowConstraints rowConstraints0 = new RowConstraints();
        RowConstraints rowConstraints1 = new RowConstraints();
        RowConstraints rowConstraints2 = new RowConstraints();
        RowConstraints rowConstraints3 = new RowConstraints();
        RowConstraints rowConstraints4 = new RowConstraints();
        Label hostLabel = new Label();
        Label datumLabel = new Label();
        Label tijdLabel = new Label();
        Label aantalAanmeldingLabel = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();
        Label label7 = new Label();
        Label label8 = new Label();
        Label label9 = new Label();
        Label label10 = new Label();
        Label label11 = new Label();
        AnchorPane anchorPane = new AnchorPane();
        listView = new ListView();
        Label label12 = new Label();
        // de int count wordt gebruikt voor het tellen van aantal aangemlde bewoners....
        int count = 0;
        // aanmaken van Strings met lege value...
        String postcode = "";
        String strHuisnummer = "";
        String Aantalaanmeldingen = "";
        String aangemeldebewoner = "";
        // deze boolean geeft aan of bewooner in de lijst voorkomt (standaard wordt deze op false gezet) in de code wordt deze true gezet als aangemlede bewooner in de lijst voorkomt.
        boolean bewonerislist = false;

        //

        try {
            con = DBCPDataSource.getConnection();
            // ophalen van gevens van host
            int aanmeldingID = maaltijden.maaltijdID;
            String query1 = ("Select buurtmaaltijd.buurtbewoners.*, buurtmaaltijd.maaltijden.maaltijdID From buurtmaaltijd.buurtbewoners Inner Join buurtmaaltijd.maaltijden On buurtmaaltijd.maaltijden.telefoonnummer = buurtmaaltijd.buurtbewoners.telefoonnummer Where maaltijden.telefoonnummer = '" + maaltijden.telefoonnummer + "'");
            ResultSet result1;
            Statement st;
            st = con.createStatement();
            result1 = st.executeQuery(query1);
            result1.next();
            strHuisnummer = String.valueOf(result1.getInt("huisnummer"));
            postcode = result1.getString("postcode");
            // aanmeldigen ophalen
            String query = ("Select buurtbewoners.naam, buurtbewoners.postcode, buurtbewoners.huisnummer, buurtbewoners.telefoonnummer, aanmeldingen.maaltijdID\n"
                    + "From buurtmaaltijd.buurtbewoners \n"
                    + "Inner Join aanmeldingen On buurtbewoners.telefoonnummer = aanmeldingen.telefoonnummer\n"
                    + "where aanmeldingen.maaltijdID =  '" + aanmeldingID + "'");
            ResultSet result;
            result = st.executeQuery(query);
            aangemeldebewoner = bewooner.getNaam();
            // naam van buurtbewooners toevoeven aan listview
            while (result.next()) {
                String naam = result.getString("naam");
                if (aangemeldebewoner.equalsIgnoreCase(naam)) {
                    listView.getItems().add(result.getString("naam") + " (Ik)");
                    bewonerislist = true;
                } else {
                    listView.getItems().add(result.getString("naam"));
                }
                count++;
            }
            Aantalaanmeldingen = Integer.toString(count);
            con.close();
        } catch (Exception ex) { // opvangen van fouten
            ex.printStackTrace();
        }
//
        AnchorPane.setBottomAnchor(borderPaneDetailsbuurtmaaltijden, 0.0);
        AnchorPane.setLeftAnchor(borderPaneDetailsbuurtmaaltijden, 0.0);
        AnchorPane.setRightAnchor(borderPaneDetailsbuurtmaaltijden, 0.0);
        AnchorPane.setTopAnchor(borderPaneDetailsbuurtmaaltijden, 0.0);
        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setPrefHeight(76.0);
        label.setPrefWidth(499.0);
        label.setText("Buurtmaaltijd");
        label.setFont(new Font(48.0));
        borderPaneDetailsbuurtmaaltijden.setTop(label);

        BorderPane.setAlignment(buttonBar, javafx.geometry.Pos.CENTER);
        buttonBar.setPrefHeight(91.0);
        buttonBar.setPrefWidth(476.0);

        terugOverzichtBTN.setMnemonicParsing(false);
        terugOverzichtBTN.setText("Terug na overzicht");
        terugOverzichtBTN.setOpaqueInsets(new Insets(0.0));
        afmeldenBTN.setMnemonicParsing(false);
        afmeldenBTN.setPrefHeight(0.0);
        afmeldenBTN.setPrefWidth(142.0);
        afmeldenBTN.setText("Afmelden");
        buttonBar.setPadding(new Insets(0.0, 20.0, 0.0, 0.0));

        aanmeldenBTN.setMnemonicParsing(false);
        aanmeldenBTN.setPrefHeight(0.0);
        aanmeldenBTN.setPrefWidth(142.0);
        aanmeldenBTN.setText("Aanmelden");
        buttonBar.setPadding(new Insets(0.0, 20.0, 0.0, 0.0));
        borderPaneDetailsbuurtmaaltijden.setBottom(buttonBar);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(281.0);
        gridPane.setPrefWidth(311.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(234.0);
        columnConstraints.setMinWidth(0.0);
        columnConstraints.setPrefWidth(155.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(329.0);
        columnConstraints0.setMinWidth(0.0);
        columnConstraints0.setPrefWidth(136.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        hostLabel.setText("Gastheer/gastvrouw:");

        GridPane.setRowIndex(datumLabel, 1);
        datumLabel.setText("Datum:");

        GridPane.setRowIndex(tijdLabel, 2);
        tijdLabel.setText("Tijd:");

        GridPane.setRowIndex(aantalAanmeldingLabel, 3);
        aantalAanmeldingLabel.setText("Aantal aanmeldigen:");

        GridPane.setRowIndex(label4, 4);
        label4.setText("Postcode:");

        GridPane.setRowIndex(label5, 5);
        label5.setText("Huisnummer:");

        GridPane.setColumnIndex(label6, 1);
        label6.setText(maaltijden.naam);

        GridPane.setColumnIndex(label7, 1);
        GridPane.setRowIndex(label7, 1);
        label7.setText(maaltijden.datum);

        GridPane.setColumnIndex(label8, 1);
        GridPane.setRowIndex(label8, 2);
        label8.setText(maaltijden.tijd);

        GridPane.setColumnIndex(label9, 1);
        GridPane.setRowIndex(label9, 3);
        label9.setText(Aantalaanmeldingen);

        GridPane.setColumnIndex(label10, 1);
        GridPane.setRowIndex(label10, 4);
        label10.setText(postcode);

        GridPane.setColumnIndex(label11, 1);
        GridPane.setRowIndex(label11, 5);
        label11.setText(strHuisnummer);
        gridPane.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        borderPaneDetailsbuurtmaaltijden.setLeft(gridPane);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(281.0);
        anchorPane.setPrefWidth(0.0);
        anchorPane.setOpaqueInsets(new Insets(0.0));
        BorderPane.setMargin(anchorPane, new Insets(0.0, 20.0, 0.0, 0.0));

        AnchorPane.setBottomAnchor(listView, 0.0);
        AnchorPane.setLeftAnchor(listView, 0.0);
        AnchorPane.setRightAnchor(listView, 0.0);
        AnchorPane.setTopAnchor(listView, 29.0);
        listView.setLayoutY(29.0);
        listView.setPrefHeight(252.0);
        listView.setPrefWidth(356.0);

        label12.setLayoutY(6.0);
        label12.setText("Aangemelde buurtbewooners");
        borderPaneDetailsbuurtmaaltijden.setCenter(anchorPane);
        // aanmelden of afmeld knop toonen op basis van bewonerlist
        if (bewonerislist) { // if bewonerislist True
            buttonBar.getButtons().addAll(afmeldenBTN);
        } else if (!bewonerislist) { // if bewonerislist False
            buttonBar.getButtons().addAll(aanmeldenBTN);
        }
        buttonBar.getButtons().add(terugOverzichtBTN);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getChildren().add(hostLabel);
        gridPane.getChildren().add(datumLabel);
        gridPane.getChildren().add(tijdLabel);
        gridPane.getChildren().add(aantalAanmeldingLabel);
        gridPane.getChildren().add(label4);
        gridPane.getChildren().add(label5);
        gridPane.getChildren().add(label6);
        gridPane.getChildren().add(label7);
        gridPane.getChildren().add(label8);
        gridPane.getChildren().add(label9);
        gridPane.getChildren().add(label10);
        gridPane.getChildren().add(label11);
        anchorPane.getChildren().add(listView);
        anchorPane.getChildren().add(label12);
        // toevoegen aan de root class
        System.out.println(maaltijden.tijd);
        terugOverzichtBTN.setOnAction(event -> {
            borderPaneDetailsbuurtmaaltijden.setVisible(false);
            borderPaneBuurtmaaltijden.setVisible(true);

        });

        afmeldenBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    con = DBCPDataSource.getConnection();
                    Statement stat = con.createStatement();
                    PreparedStatement pst = null;
                    String telefoonnummer = bewooner.getTelefoonnummer();
                    int maaltijdID = maaltijden.maaltijdID;
                    String strInsert = "DELETE FROM aanmeldingen WHERE aanmeldingen.maaltijdId = ? and aanmeldingen.telefoonnummer = ? ";
                    pst = con.prepareStatement(strInsert);
                    pst.setInt(1, maaltijdID);
                    pst.setString(2, telefoonnummer);
                    pst.executeUpdate();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TabMaaltijdOverzicht.class.getName()).log(Level.SEVERE, null, ex);
                }
                borderPaneDetailsbuurtmaaltijden.setVisible(false);
                borderPaneBuurtmaaltijden.setVisible(true);
            }
        });

        aanmeldenBTN.setOnAction(event -> {
            try {
                con = DBCPDataSource.getConnection();
                Statement stat = con.createStatement();
                PreparedStatement pst = null;
                String telefoonnummer = bewooner.getTelefoonnummer();
                int maaltijdID = maaltijden.maaltijdID;
                String insertString = "INSERT INTO aanmeldingen (maaltijdID, telefoonnummer) VALUES (?, ?);";
                pst = con.prepareStatement(insertString);
                pst.setInt(1, maaltijdID);
                pst.setString(2, telefoonnummer);
                int insertAanmelding = pst.executeUpdate();
                if (insertAanmelding == 1) {
                    borderPaneDetailsbuurtmaaltijden.setVisible(false);
                    borderPaneBuurtmaaltijden.setVisible(true);
                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TabMaaltijdOverzicht.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

}
