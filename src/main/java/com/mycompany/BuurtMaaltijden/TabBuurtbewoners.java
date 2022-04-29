package com.mycompany.BuurtMaaltijden;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class TabBuurtbewoners {

    protected final BorderPane borderPane;
    protected final ListView listView;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Label label;
    protected final Label label0;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final RowConstraints rowConstraints7;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final ListView overzichtAllergie;
    protected final TextField tfNaam;
    protected final TextField tfTelefoonnummer;
    protected final GridPane gridPane1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints8;
    protected final RowConstraints rowConstraints9;
    protected final RowConstraints rowConstraints10;
    protected final TextField tfHuisnummer;
    protected final TextField tfStraat;
    protected final TextField tfPostcode;
    protected final ButtonBar buttonBar;
    protected final Button toonDetailsBuurtbewoonerBTN;
    
    protected final Label label5;
    protected final TableView<Buurtbewoners> TVbuurtbewoonerOverzicht;
    protected final TableColumn colNaam;

    public TabBuurtbewoners(AnchorPane Buurtmaaltijden) throws SQLException {
        borderPane = new BorderPane();
        listView = new ListView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        gridPane0 = new GridPane();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        rowConstraints7 = new RowConstraints();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        overzichtAllergie = new ListView();
        tfNaam = new TextField();
        tfTelefoonnummer = new TextField();
        gridPane1 = new GridPane();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints8 = new RowConstraints();
        rowConstraints9 = new RowConstraints();
        rowConstraints10 = new RowConstraints();
        tfHuisnummer = new TextField();
        tfStraat = new TextField();
        tfPostcode = new TextField();
        buttonBar = new ButtonBar();

        toonDetailsBuurtbewoonerBTN = new Button();
        label5 = new Label();
        TVbuurtbewoonerOverzicht = new TableView();
        colNaam = new TableColumn();
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);
        AnchorPane.setTopAnchor(borderPane, 0.0);
        borderPane.setPrefHeight(400.0);
        borderPane.setPrefWidth(600.0);
  toonDetailsBuurtbewoonerBTN.disableProperty().bind(TVbuurtbewoonerOverzicht.getSelectionModel().selectedItemProperty().isNull());
        BorderPane.setAlignment(TVbuurtbewoonerOverzicht, javafx.geometry.Pos.CENTER);
        TVbuurtbewoonerOverzicht.setPrefHeight(200.0);
        TVbuurtbewoonerOverzicht.setPrefWidth(200.0);

        colNaam.setPrefWidth(199.0);
        colNaam.setText("Selecteer een buurtbewooner");
        BorderPane.setMargin(TVbuurtbewoonerOverzicht, new Insets(0.0, 0.0, 0.0, 20.0));
        borderPane.setLeft(TVbuurtbewoonerOverzicht);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(150.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(105.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(219.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(205.0);

        rowConstraints0.setMaxHeight(63.0);
        rowConstraints0.setMinHeight(0.0);
        rowConstraints0.setPrefHeight(32.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(103.0);
        rowConstraints1.setMinHeight(0.0);
        rowConstraints1.setPrefHeight(43.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(103.0);
        rowConstraints2.setMinHeight(0.0);
        rowConstraints2.setPrefHeight(80.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(227.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(58.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(205.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(87.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(label, 1);
        label.setText("Naam:");

        GridPane.setRowIndex(label0, 2);
        label0.setText("Telefoonnummer:");

        GridPane.setRowIndex(gridPane0, 3);
        gridPane0.setPrefHeight(42.0);
        gridPane0.setPrefWidth(200.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(186.0);
        columnConstraints1.setMinWidth(0.0);
        columnConstraints1.setPrefWidth(165.0);

        rowConstraints5.setMaxHeight(71.0);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(28.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMaxHeight(160.0);
        rowConstraints6.setMinHeight(0.0);
        rowConstraints6.setPrefHeight(35.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints7.setMaxHeight(187.0);
        rowConstraints7.setMinHeight(10.0);
        rowConstraints7.setPrefHeight(27.0);
        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label1.setText("Straat:");

        GridPane.setRowIndex(label2, 1);
        label2.setText("Huisnummer:");

        GridPane.setRowIndex(label3, 2);
        label3.setText("Postcode:");

        GridPane.setRowIndex(label4, 5);
        label4.setPrefHeight(17.0);
        label4.setPrefWidth(56.0);
        label4.setText("Allergie:");

        GridPane.setColumnIndex(overzichtAllergie, 1);
        GridPane.setRowIndex(overzichtAllergie, 5);
        overzichtAllergie.setDisable(true);
        overzichtAllergie.setPrefHeight(200.0);
        overzichtAllergie.setPrefWidth(200.0);

        GridPane.setColumnIndex(tfNaam, 1);
        GridPane.setRowIndex(tfNaam, 1);
        tfNaam.setDisable(true);
        tfNaam.setEditable(false);

        GridPane.setColumnIndex(tfTelefoonnummer, 1);
        GridPane.setRowIndex(tfTelefoonnummer, 2);
        tfTelefoonnummer.setDisable(true);
        tfTelefoonnummer.setEditable(false);

        GridPane.setColumnIndex(gridPane1, 1);
        GridPane.setRowIndex(gridPane1, 3);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        rowConstraints8.setMinHeight(10.0);
        rowConstraints8.setPrefHeight(30.0);
        rowConstraints8.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints9.setMinHeight(10.0);
        rowConstraints9.setPrefHeight(30.0);
        rowConstraints9.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints10.setMinHeight(10.0);
        rowConstraints10.setPrefHeight(30.0);
        rowConstraints10.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(tfHuisnummer, 1);

        tfHuisnummer.setDisable(true);
        tfHuisnummer.setEditable(false);

        tfStraat.setDisable(true);
        tfStraat.setEditable(false);

        GridPane.setRowIndex(tfPostcode, 2);
        tfPostcode.setDisable(true);
        tfPostcode.setEditable(false);
        BorderPane.setMargin(gridPane, new Insets(0.0, 0.0, 0.0, 50.0));
        gridPane.setPadding(new Insets(0.0, 20.0, 0.0, 0.0));
        borderPane.setCenter(gridPane);

        BorderPane.setAlignment(buttonBar, javafx.geometry.Pos.CENTER);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);



        toonDetailsBuurtbewoonerBTN.setMnemonicParsing(false);
        toonDetailsBuurtbewoonerBTN.setText("Toon details bewooner");
        toonDetailsBuurtbewoonerBTN.setOpaqueInsets(new Insets(0.0));
        buttonBar.setPadding(new Insets(0.0, 20.0, 0.0, 0.0));
        borderPane.setBottom(buttonBar);

        BorderPane.setAlignment(label5, javafx.geometry.Pos.CENTER);
        label5.setText("Buurtbewoners");
        label5.setFont(new Font("Calibri Bold Italic", 40.0));
        borderPane.setTop(label5);

        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints0);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1, rowConstraints2, rowConstraints3, rowConstraints4);
        gridPane.getChildren().addAll(label, label0);
        gridPane0.getColumnConstraints().addAll(columnConstraints1);
        gridPane0.getRowConstraints().addAll(rowConstraints5, rowConstraints6, rowConstraints7);
        gridPane0.getChildren().addAll(label1, label2, label3);
        gridPane.getChildren().addAll(gridPane0, label4, overzichtAllergie, tfNaam, tfTelefoonnummer);
        gridPane1.getColumnConstraints().addAll(columnConstraints2);
        gridPane1.getRowConstraints().addAll(rowConstraints8, rowConstraints9, rowConstraints10);
        gridPane1.getChildren().addAll(tfHuisnummer, tfStraat, tfPostcode);
        gridPane.getChildren().addAll(gridPane1);
        buttonBar.getButtons().addAll(toonDetailsBuurtbewoonerBTN);
        TVbuurtbewoonerOverzicht.getColumns().add(colNaam);
        // toevoegen aan de root class
        Buurtmaaltijden.getChildren().addAll(borderPane);
        // toon listview buurtbewoners
        showBuurtbewoners();

        toonDetailsBuurtbewoonerBTN.setOnAction(event -> {
            //show just one selected row
            overzichtAllergie.getItems().clear();
        
            Buurtbewoners buurtbewooner = TVbuurtbewoonerOverzicht.getSelectionModel().getSelectedItem();

            int strHuisnummer = buurtbewooner.getHuisnummer();
            String s = String.valueOf(strHuisnummer);
            tfHuisnummer.setText(s);
            tfNaam.setText(buurtbewooner.getNaam());
            tfTelefoonnummer.setText(buurtbewooner.getTelefoonnummer());
            tfStraat.setText("Aadstraat");
            tfPostcode.setText(buurtbewooner.getPostcode());
            try {
                // call method to display overzichtAllergie
                Methods.toonAllergie(buurtbewooner, overzichtAllergie);
            } catch (SQLException ex) {
                Logger.getLogger(TabBuurtbewoners.class.getName()).log(Level.SEVERE, null, ex);
            }
                try {
                showBuurtbewoners();
            } catch (SQLException ex) {
                Logger.getLogger(TabBuurtbewoners.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // ophalen van buurtbewooner
    public ObservableList<Buurtbewoners> getBuurtbewonersList() throws SQLException {
        Connection con = null;
        ObservableList<Buurtbewoners> buurtbewonersList = FXCollections.observableArrayList();
        try {

            con = DBCPDataSource.getConnection();
            String query = "SELECT * FROM buurtbewoners";
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            Buurtbewoners buurtbewoners;
            while (rs.next()) {
                buurtbewoners = new Buurtbewoners(rs.getString("telefoonnummer"), rs.getString("naam"), rs.getString("postcode"), rs.getInt("huisnummer"));
                buurtbewonersList.add(buurtbewoners);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (con != null && !con.isClosed()) { // validate conn whether it is null 
                con.close();
            }
           
        }
    return buurtbewonersList;
    }

    // toonen van buurtbewoners
    public void showBuurtbewoners() throws SQLException {

        ObservableList<Buurtbewoners> list = getBuurtbewonersList();
        colNaam.setCellValueFactory(new PropertyValueFactory<Buurtbewoners, String>("naam"));
        TVbuurtbewoonerOverzicht.setItems(list);
    }

}
