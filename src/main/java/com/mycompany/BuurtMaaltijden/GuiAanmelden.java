// dit scherm krijg de gebruiker te zien, om keuze te maken waarmee hij ""aanmeld".
package com.mycompany.BuurtMaaltijden;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public final class GuiAanmelden {

    protected final TableView<Buurtbewoners> tvBuurtbewoners;
    protected final TableColumn colTelefoonnummer;
    protected final TableColumn colNaam;

    public GuiAanmelden(BorderPane aanmelden, Stage primaryStage) {

        StackPane BuurtBewoners = new StackPane();
        ButtonBar buttonBar = new ButtonBar();
        Button aanmeldenBTN = new Button();
        Text text = new Text();
        tvBuurtbewoners = new TableView();
        colTelefoonnummer = new TableColumn();
        colNaam = new TableColumn();

        BorderPane.setAlignment(tvBuurtbewoners, javafx.geometry.Pos.CENTER);
        tvBuurtbewoners.setPrefHeight(344.0);
        tvBuurtbewoners.setPrefWidth(438.0);
        BorderPane.setMargin(tvBuurtbewoners, new Insets(20.0, 100.0, 0.0, 100.0));
        aanmelden.setCenter(tvBuurtbewoners);

        BorderPane.setAlignment(buttonBar, javafx.geometry.Pos.CENTER);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);

        aanmeldenBTN.setMnemonicParsing(false);
        aanmeldenBTN.setText("Login");
        BorderPane.setMargin(buttonBar, new Insets(0.0));
        buttonBar.setPadding(new Insets(0.0, 20.0, 0.0, 0.0));
        aanmelden.setBottom(buttonBar);

        BorderPane.setAlignment(text, javafx.geometry.Pos.CENTER);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Aanmelden als:");
        aanmelden.setTop(text);

        BorderPane.setAlignment(tvBuurtbewoners, javafx.geometry.Pos.CENTER);
        tvBuurtbewoners.setPrefHeight(117.0);
        tvBuurtbewoners.setPrefWidth(600.0);
        tvBuurtbewoners.refresh();
        colTelefoonnummer.setId("buurtbewoonersID");
        colTelefoonnummer.setPrefWidth(150.0);
        colTelefoonnummer.setText("ID");

        colNaam.setId("naam");
        colNaam.setMinWidth(0.0);
        colNaam.setPrefWidth(174.0);
        colNaam.setText("Naam");

        tvBuurtbewoners.getColumns().add(colTelefoonnummer);
        tvBuurtbewoners.getColumns().add(colNaam);
        buttonBar.getButtons().add(aanmeldenBTN);

        //functie aan roepen voor het tonen van Buurtbewoners
        showBuurtbewoners();

        // eventhandler voor aanmeldknop
        aanmeldenBTN.setOnAction(event -> {
            //show just one selected row
            ObservableList<Buurtbewoners> buurtbewonerlist;
            buurtbewonerlist = tvBuurtbewoners.getSelectionModel().getSelectedItems();
            Buurtbewoners buurtbewooner = tvBuurtbewoners.getSelectionModel().getSelectedItem();
            System.out.println(buurtbewonerlist.get(0).getPostcode());
            try {
                
                new GuiTabPane(BuurtBewoners, buurtbewooner);
            } catch (SQLException ex) {
                Logger.getLogger(GuiAanmelden.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(BuurtBewoners, 1200, 800);
            primaryStage.setTitle("Buurtmaaltijden");
            primaryStage.setScene(scene);
            primaryStage.show();
        });

    }

// ophalen van buurtbewooner
    public ObservableList<Buurtbewoners> getBuurtbewonersList() {
        ObservableList<Buurtbewoners> buurtbewonersList = FXCollections.observableArrayList();
        try {
            Connection conn = DBCPDataSource.getConnection();
            String query = "SELECT * FROM buurtbewoners";
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Buurtbewoners buurtbewoners;
            while (rs.next()) {
                buurtbewoners = new Buurtbewoners(rs.getString("telefoonnummer"), rs.getString("naam"), rs.getString("postcode"), rs.getInt("huisnummer"));
                buurtbewonersList.add(buurtbewoners);
            }
        } catch (SQLException ex) {
        }
        return buurtbewonersList;
    }

// toonen van buurtbewoners
    public void showBuurtbewoners() {
        ObservableList<Buurtbewoners> list = getBuurtbewonersList();
        colTelefoonnummer.setCellValueFactory(new PropertyValueFactory<Buurtbewoners, String>("telefoonnummer"));
        colNaam.setCellValueFactory(new PropertyValueFactory<Buurtbewoners, String>("naam"));
        tvBuurtbewoners.setItems(list);
    }
}
