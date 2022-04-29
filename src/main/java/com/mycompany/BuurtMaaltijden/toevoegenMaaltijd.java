package com.mycompany.BuurtMaaltijden;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
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

public class toevoegenMaaltijd {

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
    Spinner uurspinner = new Spinner();
    Spinner minspinner = new Spinner();

    public toevoegenMaaltijd(AnchorPane BorderPaneNieuweMaaltijd, BorderPane BorderPaneOverzichtMijnmaaltijden, Buurtbewoners bewooner) {
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

        uurspinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 23, 17));
        uurspinner.setEditable(true);

        minspinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 59, 00));
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

        // terug na  mijn overzicht
        terugBTN.setOnAction(event -> {
            BorderPaneNieuweMaaltijd.setVisible(false);
            BorderPaneOverzichtMijnmaaltijden.setVisible(true);
        });

        // button disble als invoer velden leeg zijn.
        BorderPaneNieuweMaaltijd.getChildren().add(borderPane);
        opslaanBTN.disableProperty().bind(
                (datePicker.valueProperty().isNull())
                        .or(uurspinner.valueProperty().isNull())
                        .or(uurspinner.valueProperty().isNull())
        );

        // opslaan van ingevulde gegevens
        opslaanBTN.setOnAction((ActionEvent event) -> {
            try {
                int maaltijdID = 0;
                String telefoonnummer = null;
                String datum = null;
                String tijd = null;
                String naam = null;
                boolean datumbestaat = false;
                Maaltijden s = new Maaltijden(maaltijdID, telefoonnummer, datum, tijd, naam);

                int uur = (Integer) uurspinner.getValue();
                int min = (Integer) minspinner.getValue();
                // int to String

                String strU = Integer.toString(uur);
                String strM = Integer.toString(min);
                // tijd
                //set tijd
                s.setTijd(strU + ":" + strM);
                datum = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                //set telefoonnummer
                s.setTelefoonnummer(bewooner.getTelefoonnummer());
                //set tijd

                //set datum
                s.setDatum(datum);

                Connection con = DBCPDataSource.getConnection();
                String query = "Select * From maaltijden where datum = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, datum);
                ResultSet rs = pst.executeQuery();

                // while op te controleren of datum wat ingevuld is voor komt in database.
                while (rs.next()) {
                    String dateDB = (rs.getString("datum"));
                    System.out.print(dateDB);
                    if (datum.equals(dateDB)) {
                        datumbestaat = true;
                    }
                }

                if (!datumbestaat) { // als de datum niet bestaat
                    String strInsert = "INSERT INTO maaltijden (`telefoonnummer`, `datum`, `tijd`) VALUES (?, ?, ?)";
                    PreparedStatement pst1;
                    pst1 = con.prepareStatement(strInsert);
                    pst1.setString(1, s.getTelefoonnummer());
                    pst1.setString(2, s.getDatum());
                    pst1.setString(3, s.getTijd());
                    pst1.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Maaltijd toegevoed");
                    alert.setHeaderText(null);
                    alert.setContentText("De maaltijd is toegevoegd");
                    alert.showAndWait();
                }

                if (datumbestaat) { // als de ingevulde datum gelijk is aan huidge maaltijd.
                    System.out.println("datumbestaat = true");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Maaltijd toegevoed");
                    alert.setHeaderText(null);
                    alert.setContentText("De datum " + datum + " is bezet. Kies een andere datum of meld jezelf aan via  geplande buurtmaalijden.");
                    alert.showAndWait();
                }

                con.close();
            } catch (SQLException se) {
                System.out.println("Error : " + se.getMessage());
            }
        });
    }
}
