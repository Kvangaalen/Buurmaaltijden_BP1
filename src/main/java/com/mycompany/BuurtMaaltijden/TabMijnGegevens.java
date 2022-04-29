package com.mycompany.BuurtMaaltijden;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class TabMijnGegevens {

    protected final ListView<String> overzichtAllergie;

    public TabMijnGegevens(BorderPane AnchorPaneMijnGegevens, Buurtbewoners bewooner) throws SQLException {
        // initialiseren variabele
        GridPane gridPane = new GridPane();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        ColumnConstraints columnConstraints0 = new ColumnConstraints();
        RowConstraints rowConstraints = new RowConstraints();
        RowConstraints rowConstraints0 = new RowConstraints();
        RowConstraints rowConstraints1 = new RowConstraints();
        RowConstraints rowConstraints2 = new RowConstraints();
        RowConstraints rowConstraints3 = new RowConstraints();
        Label naamLB = new Label();
        Label telefoonLB = new Label();
        Label postcodeLB = new Label();
        Label huisnummerLB = new Label();

        Label allergieLB = new Label();
        ListView allergieSelectetenListView = new ListView();
        overzichtAllergie = new ListView();
        TextField naamTF = new TextField();
        TextField telefoonTF = new TextField();
        TextField postcodeTF = new TextField();
        TextField huisnummerTF = new TextField();
        ChoiceBox choiceBox = new ChoiceBox();
        Label label4 = new Label();
        ButtonBar buttonBar = new ButtonBar();
        Button OpslaanBTN = new Button();
        Button testBTN = new Button();
        testBTN.setText("test");
        Button herladenBTN = new Button();
        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        allergieSelectetenListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        naamLB.setText("Naam:");

        GridPane.setRowIndex(telefoonLB, 1);
        telefoonLB.setText("Telefoonnummer:");

        GridPane.setRowIndex(postcodeLB, 2);
        postcodeLB.setText("Postcode");

        GridPane.setRowIndex(huisnummerLB, 3);
        huisnummerLB.setText("Huisnummer");

        GridPane.setRowIndex(allergieLB, 4);
        allergieLB.setText("Allergie");

        GridPane.setColumnIndex(naamTF, 1);
        naamTF.setText(bewooner.getNaam());

        GridPane.setColumnIndex(telefoonTF, 1);
        GridPane.setRowIndex(telefoonTF, 1);
        telefoonTF.setText(bewooner.getTelefoonnummer());

        GridPane.setColumnIndex(postcodeTF, 1);
        GridPane.setRowIndex(postcodeTF, 2);
        postcodeTF.setText(bewooner.getPostcode());

        GridPane.setColumnIndex(huisnummerTF, 1);
        GridPane.setRowIndex(huisnummerTF, 3);
        int huisnummerINT = bewooner.getHuisnummer();
        String huisnummer = Integer.toString(huisnummerINT);
        huisnummerTF.setText(huisnummer);

        GridPane.setColumnIndex(choiceBox, 1);
        GridPane.setRowIndex(choiceBox, 4);
        choiceBox.setPrefHeight(25.0);
        choiceBox.setPrefWidth(250.0);
        BorderPane.setMargin(gridPane, new Insets(0.0, 50.0, 0.0, 50.0));
        AnchorPaneMijnGegevens.setCenter(gridPane);

        BorderPane.setAlignment(label4, javafx.geometry.Pos.CENTER);
        label4.setText("Mijn Gegevens");
        label4.setFont(new Font("System Bold Italic", 60.0));
        AnchorPaneMijnGegevens.setTop(label4);

        BorderPane.setAlignment(buttonBar, javafx.geometry.Pos.CENTER);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);
        GridPane.setRowIndex(allergieSelectetenListView, 4);
        GridPane.setColumnIndex(allergieSelectetenListView, 1);
        allergieSelectetenListView.getItems().addAll("Gluten", "Schaaldieren", "Eieren", "Vis", "Pinda", "Soja", "Soja", "Lactose", "Noten", "Selderij", "Mosterd", "Sesamzaad", "Zwaveldioxide", "Lupine", "Weekdieren");
        GridPane.setRowIndex(overzichtAllergie, 4);
        GridPane.setColumnIndex(overzichtAllergie, 2);
        herladenBTN.setMnemonicParsing(false);
        herladenBTN.setText("herladen");
        OpslaanBTN.setMnemonicParsing(false);
        OpslaanBTN.setText("Oplsaan");
        BorderPane.setMargin(buttonBar, new Insets(0.0));
        buttonBar.setPadding(new Insets(0.0, 50.0, 0.0, 0.0));
        AnchorPaneMijnGegevens.setBottom(buttonBar);
        // add to parent class
        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints0);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1, rowConstraints2, rowConstraints3);
        gridPane.getChildren().addAll(naamLB, telefoonLB, postcodeLB, huisnummerLB, allergieLB);
        gridPane.getChildren().addAll(naamTF, telefoonTF, postcodeTF, huisnummerTF, allergieSelectetenListView, overzichtAllergie);
        buttonBar.getButtons().addAll(OpslaanBTN);
        // knop disable maken als er niks is ingevuld
        OpslaanBTN.disableProperty().bind(
                Bindings.isEmpty(naamTF.textProperty())
                        .or(Bindings.isEmpty(telefoonTF.textProperty()))
                        .or(Bindings.isEmpty(postcodeTF.textProperty()))
                        .or(Bindings.isEmpty(huisnummerTF.textProperty()))
        );

        // eventhandler voor opslaan knop
        OpslaanBTN.setOnAction(event -> {
            Connection con;
            String strNaam = naamTF.getText();
            String StrPostcode = postcodeTF.getText();
            String strHuisnummer = huisnummerTF.getText();
            String strTelefoonnummer = telefoonTF.getText();
            String strOldTelefoonummer = bewooner.getTelefoonnummer();
            String strUpdateBuurtbewoners = "UPDATE buurtbewoners SET naam = '" + strNaam + "', postcode = '" + StrPostcode + "', huisnummer = '" + strHuisnummer + "', telefoonnummer = '" + strTelefoonnummer + "' WHERE telefoonnummer = '" + strOldTelefoonummer + "'";
            String strUpdateAllergie = "UPDATE allergie SET telefoonnummer = '" + strTelefoonnummer + "' WHERE telefoonnummer = '" + strOldTelefoonummer + "'";
            String strUpdateAanmeldingen = "UPDATE aanmeldingen SET telefoonnummer = '" + strTelefoonnummer + "' WHERE telefoonnummer = '" + strOldTelefoonummer + "'";
            if (huisnummerTF.getText().matches("[0-9]")) {
                System.out.println("DEBUG11");
            }

            if (telefoonTF.getText().matches("\\d{10}")) { // CHECK OF TELEFOONNUMMER CORRECT IS.
                try {
                    con = DBCPDataSource.getConnection();
                    Statement stat = con.createStatement();
                    int gelukt = stat.executeUpdate(strUpdateBuurtbewoners);
                    int gelukt2 = stat.executeUpdate(strUpdateAllergie);
                    int updateAanmelding = stat.executeUpdate(strUpdateAanmeldingen);
                    System.out.print("gelukt" + gelukt);
                    System.out.print(gelukt2);
                    System.out.print(updateAanmelding);
                    bewooner.setNaam(strNaam);
                    bewooner.setPostcode(StrPostcode);
                    bewooner.setTelefoonnummer(strTelefoonnummer);
                    // convert string to int...
                    int i = Integer.parseInt(strHuisnummer);
                    bewooner.setHuisnummer(i);
                    con.close();

                } catch (SQLException se) {
                    System.out.println(se);
                }
                try {
                    con = DBCPDataSource.getConnection();
                    Statement stat = con.createStatement();

                    PreparedStatement pst;
                    String telefoonnummer = bewooner.getTelefoonnummer();
                    ObservableList<String> buurtbewonerlist;
                    buurtbewonerlist = allergieSelectetenListView.getSelectionModel().getSelectedItems();

                    String strInsert = "DELETE FROM allergie WHERE ( allergie.telefoonnummer  = " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert);
                    String insertString = "INSERT INTO allergie (allergieID, telefoonnummer) VALUES (?, ?);";
                    pst = con.prepareStatement(insertString);
                    for (String allergie : buurtbewonerlist) {
                        int allergieid = 0;
                        switch (allergie) {
                            case "Gluten":
                                allergieid = 1;
                                break;
                            case "Schaaldieren":
                                allergieid = 2;
                                break;
                            case "Eieren":
                                allergieid = 3;
                                break;
                            case "Vis":
                                allergieid = 4;
                                break;
                            case "Pinda":
                                allergieid = 5;
                                break;
                            case "Soja":
                                allergieid = 6;
                                break;
                            case "Lactose":
                                allergieid = 7;
                                break;
                            case "Noten ":
                                allergieid = 8;
                                break;
                            case "Selderij":
                                allergieid = 9;
                                break;
                            case "Mosterd":
                                allergieid = 10;
                                break;
                            case "Sesamzaad":
                                allergieid = 11;
                                break;
                            case "Zwaveldioxide":
                                allergieid = 12;
                                break;
                            case "Lupine ":
                                allergieid = 13;
                                break;
                            case "Weekdieren":
                                allergieid = 14;
                                break;
                        }
                        pst.setInt(1, allergieid);
                        pst.setString(2, telefoonnummer);

                        pst.executeUpdate();
                        // methods voor toonen van allergie en listview opschonen
    

                    }
                        overzichtAllergie.getItems().clear();
                        Methods.toonAllergie(bewooner, overzichtAllergie);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Update gelukt!");
                        alert.setHeaderText(null);
                        alert.setContentText("Gegevens zijn aangepast");
                        alert.showAndWait();
                        con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TabMijnGegevens.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Telefoon nummer fout");
                alert.setHeaderText(null);
                alert.setContentText("Vul een geldig telefoonnnummer (0612345678)");
                alert.showAndWait();
            }

        });

        herladenBTN.setOnAction(event -> {
            postcodeTF.setText(bewooner.getPostcode());
            naamTF.setText(bewooner.getNaam());
            telefoonTF.setText(bewooner.getTelefoonnummer());
            int i = (bewooner.getHuisnummer());
            String s = String.valueOf(i);
            huisnummerTF.setText(s);
        });
        // run methods to show allegie
        Methods.toonAllergie(bewooner, overzichtAllergie);
    }

    // ophalen van buurtbewooner
    public ObservableList<Allergie> getAllergieList(Buurtbewoners bewooner) {
        ObservableList<Allergie> allergieList = FXCollections.observableArrayList();
        try {
            System.out.println("tel " + bewooner.getTelefoonnummer());
            String telefoonnummer = bewooner.getTelefoonnummer();
            Connection conn = DBCPDataSource.getConnection();
            String query = "SELECT * FROM allergie WHERE telefoonnummer = " + telefoonnummer + "";
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Allergie allergie;
            while (rs.next()) {
                String allergieID = rs.getString("allergieID");
                int allergieID_INT = Integer.parseInt(allergieID);
                switch (allergieID_INT) {
                    case 1:
                        overzichtAllergie.getItems().add("gluten");
                        break;
                    case 2:
                        overzichtAllergie.getItems().add("Schaaldieren");
                        break;
                    case 3:
                        overzichtAllergie.getItems().add("Eieren");
                        break;
                    case 4:
                        overzichtAllergie.getItems().add("Vis");
                        break;
                    case 5:
                        overzichtAllergie.getItems().add("Soja");
                        break;
                    case 6:
                        overzichtAllergie.getItems().add("lactose");
                        break;
                    case 7:
                        overzichtAllergie.getItems().add("Noten");
                        break;
                    case 8:
                        overzichtAllergie.getItems().add("Selderij");
                        break;
                    case 9:
                        overzichtAllergie.getItems().add("Noten");
                        break;
                    case 10:
                        overzichtAllergie.getItems().add("Mosterd");
                        break;
                    case 11:
                        overzichtAllergie.getItems().add("Sesamzaad");
                        break;
                    case 12:
                        overzichtAllergie.getItems().add("Noten");
                        break;
                    case 13:
                        overzichtAllergie.getItems().add("Zwaveldioxide");
                        break;
                    case 14:
                        overzichtAllergie.getItems().add("Lupine");
                        break;
                }
            }
        } catch (NumberFormatException | SQLException ex) {
        }

        return allergieList;

    }

}
