package com.mycompany.BuurtMaaltijden;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class bewerkenMaaltijd {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final DatePicker datePicker;
    protected final Label label;
    protected final Label label0;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final TextField uurTF;
    protected final TextField minTF;
    protected Label label1;
    protected final Label label2;
    protected final ButtonBar buttonBar;
    protected final Button terugBTN;
    protected final Button opslaanBTN;
    protected final Spinner uurspinner;
    protected final Spinner minspinner;

    Connection con = null;

    public bewerkenMaaltijd(AnchorPane BorderPaneBewerkenMaaltijd, BorderPane BorderPaneOverzichtMijnmaaltijden, Buurtbewoners bewooner, Maaltijden maaltijd) {
        uurspinner = new Spinner();
        minspinner = new Spinner();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        datePicker = new DatePicker();
        label = new Label();
        label0 = new Label();
        gridPane0 = new GridPane();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        uurTF = new TextField();
        minTF = new TextField();
        label1 = new Label();
        label2 = new Label();
        buttonBar = new ButtonBar();
        terugBTN = new Button();
        opslaanBTN = new Button();
        BorderPane borderPane = new BorderPane();
        int u = 0;
        int m = 0;
        try {
            Connection con = DBCPDataSource.getConnection();
            String query = "SELECT * FROM buurtmaaltijd.maaltijden where maaltijdID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            int maaltijdID = maaltijd.maaltijdID;
            ps.setInt(1, maaltijdID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tijd = rs.getString("tijd");
                String datum = rs.getString("datum");
                String uur = tijd.substring(0, 2);
                String min = tijd.substring(3, 5);
                u = Integer.parseInt(uur);
                 m = Integer.parseInt(min);
                datePicker.setValue(LocalDate.parse(datum));
            }
            con.close();
        } catch (Exception ex) {
            // opvangen van fouten
        }
        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(427.0);
        gridPane.setPrefWidth(836.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(datePicker, 1);
        GridPane.setRowIndex(datePicker, 1);
        GridPane.setMargin(datePicker, new Insets(0.0, 50.0, 0.0, 50.0));

        GridPane.setRowIndex(label, 1);
        label.setPrefHeight(17.0);
        label.setPrefWidth(180.0);
        label.setText("Datum van buurtmaaltijd nw");
        GridPane.setMargin(label, new Insets(0.0, 0.0, 0.0, 20.0));

        label0.setPrefHeight(17.0);
        label0.setPrefWidth(180.0);
        label0.setText("Tijd van buurtmaaltijd");
        label0.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        GridPane.setColumnIndex(gridPane0, 1);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(148.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(148.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(99.0);
        columnConstraints2.setMinWidth(0.0);
        columnConstraints2.setPrefWidth(3.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(200.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(149.0);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        uurspinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 23, u));
        uurspinner.setEditable(true);

        minspinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 59, m));
        minspinner.setEditable(true);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        GridPane.setRowIndex(uurspinner, 1);
        GridPane.setRowIndex(uurTF, 1);
        uurTF.setPromptText("18");
        uurTF.setOpaqueInsets(new Insets(0.0));
        GridPane.setRowIndex(minspinner, 1);
        GridPane.setColumnIndex(minspinner, 2);
        GridPane.setRowIndex(minspinner, 1);
        GridPane.setColumnIndex(minTF, 2);
        GridPane.setRowIndex(minTF, 1);
        minTF.setPrefHeight(25.0);
        minTF.setPrefWidth(0.0);
        minTF.setPromptText("00");

        label1.setPrefHeight(17.0);
        label1.setPrefWidth(180.0);
        label1.setText("Uur");

        GridPane.setColumnIndex(label2, 2);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(180.0);
        label2.setText("Min");
        gridPane0.setPadding(new Insets(0.0, 50.0, 0.0, 50.0));
        borderPane.setCenter(gridPane);

        BorderPane.setAlignment(buttonBar, javafx.geometry.Pos.CENTER);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);

        terugBTN.setMnemonicParsing(false);
        terugBTN.setText("Terug");

        opslaanBTN.setMnemonicParsing(false);
        opslaanBTN.setText("Opslaan");
        borderPane.setBottom(buttonBar);

        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints0);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1);
        gridPane.getChildren().addAll(datePicker, label, label0);
        gridPane0.getColumnConstraints().addAll(columnConstraints1, columnConstraints2, columnConstraints3);
        gridPane0.getRowConstraints().addAll(rowConstraints2, rowConstraints3);
        gridPane0.getChildren().add(label1);
        gridPane0.getChildren().add(label2);
        gridPane0.getChildren().add(uurspinner);
        gridPane0.getChildren().add(minspinner);
        gridPane.getChildren().add(gridPane0);
        buttonBar.getButtons().addAll(terugBTN, opslaanBTN);

        BorderPaneBewerkenMaaltijd.getChildren().add(borderPane);
        terugBTN.setOnAction(event -> {
            BorderPaneBewerkenMaaltijd.setVisible(false);
            BorderPaneOverzichtMijnmaaltijden.setVisible(true);
        });

        opslaanBTN.setOnAction(event -> {
            int maaltijdID = maaltijd.maaltijdID;
            String telefoonnummer = bewooner.getTelefoonnummer();
            String datum = maaltijd.datum;
            String olddatum = maaltijd.datum;
            String tijd = maaltijd.tijd;
            String naam = bewooner.getNaam();
            Maaltijden s = new Maaltijden(maaltijdID, telefoonnummer, datum, tijd, naam);
            // datum van datepicker
            datum = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            s.setDatum(datum);

            int uur = (Integer) uurspinner.getValue();
            int min = (Integer) minspinner.getValue();
            // int to String
            String strU = Integer.toString(uur);
            String strM = Integer.toString(min);
            // tijd
            //set tijd
            s.setTijd(strU + ":" + strM);
            boolean datumbestaat = false;
            try {
                System.out.println("OLD" + olddatum);
                Connection con = DBCPDataSource.getConnection();
                String query = "Select * From maaltijden where datum = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, datum);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    String dateDB = (rs.getString("datum"));
                    if (datum.equals(dateDB)) {
                        datumbestaat = true;
                    }
                }

                if (datumbestaat) { // als de datum bestaat
                    if (datum.equals(olddatum)) { //wel update
                        System.out.println("wel");
                        String strInsert = "Update maaltijden set datum =  ?, tijd = ? WHERE datum and maaltijdID = ?";
                        PreparedStatement pst1;
                        pst1 = con.prepareStatement(strInsert);
                        pst1.setString(1, s.getDatum());
                        pst1.setString(2, s.getTijd());
                        pst1.setInt(3, s.getMaaltijdID());
                        System.out.println(s.getMaaltijdID());
                        pst1.executeUpdate();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Maaltijd is bewertk!");
                        alert.setHeaderText(null);
                        alert.setContentText("Gegevens zijn aangepast");
                        alert.showAndWait();
                    } else if (!datum.equals(olddatum)) { //niet datum is andere maaltijd
                        System.out.println("niet");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Niet gelukt!");
                        alert.setHeaderText(null);
                        alert.setContentText("Er is al maaltijd gepland op deze datum.");
                        alert.showAndWait();

                    }
                } else { // new tijd mag
                    System.out.println("Wel Nieuwe datum");

                    String strInsert = "Update maaltijden set datum =  ?, tijd = ? WHERE datum and maaltijdID = ?";
                    PreparedStatement pst1;
                    pst1 = con.prepareStatement(strInsert);
                    pst1.setString(1, s.getDatum());
                    pst1.setString(2, s.getTijd());
                    pst1.setInt(3, s.getMaaltijdID());
                    System.out.println(s.getMaaltijdID());
                    pst1.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Maaltijd is bewertk!");
                    alert.setHeaderText(null);
                    alert.setContentText("Gegevens zijn aangepast");
                    alert.showAndWait();
                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(bewerkenMaaltijd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        );
    }

}
