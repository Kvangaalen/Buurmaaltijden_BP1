package com.mycompany.BuurtMaaltijden;

import static com.mycompany.BuurtMaaltijden.DBCPDataSource.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class TabMijnMaaltijden {

    protected final TableView<Maaltijden> tvBuurtbewoners;
    protected final TableColumn colDatum;
    protected final TableColumn colTijd;
    public BorderPane BorderPaneNieuweMaaltijd;
    public BorderPane BorderPaneOverzichtMijnmaaltijden;
    public Connection con = null;

    public TabMijnMaaltijden(AnchorPane AnchorPaneMijnMaaltijden, Buurtbewoners bewooner) {
        BorderPane BorderPaneOverzichtMijnmaaltijden = new BorderPane();
        AnchorPane BorderPaneNieuweMaaltijd = new AnchorPane();
        AnchorPane BorderPaneBewerkenMaaltijd = new AnchorPane();
        new toevoegenMaaltijd(BorderPaneNieuweMaaltijd, BorderPaneOverzichtMijnmaaltijden, bewooner);
        ButtonBar buttonBar = new ButtonBar();
        Button nieuwe = new Button();
        Button verwijderen = new Button();
        Button bewerken = new Button();
        Button updatelistview = new Button();
        Text text = new Text();
        tvBuurtbewoners = new TableView();
        colDatum = new TableColumn();
        colTijd = new TableColumn();
        AnchorPane.setBottomAnchor(BorderPaneOverzichtMijnmaaltijden, 0.0);
        AnchorPane.setLeftAnchor(BorderPaneOverzichtMijnmaaltijden, 0.0);
        AnchorPane.setRightAnchor(BorderPaneOverzichtMijnmaaltijden, 0.0);
        AnchorPane.setTopAnchor(BorderPaneOverzichtMijnmaaltijden, 0.0);
        BorderPaneOverzichtMijnmaaltijden.setAlignment(tvBuurtbewoners, javafx.geometry.Pos.CENTER);
        tvBuurtbewoners.setPrefHeight(344.0);
        tvBuurtbewoners.setPrefWidth(438.0);
        BorderPaneOverzichtMijnmaaltijden.setMargin(tvBuurtbewoners, new Insets(20.0, 100.0, 0.0, 100.0));
        BorderPaneOverzichtMijnmaaltijden.setCenter(tvBuurtbewoners);

        BorderPaneOverzichtMijnmaaltijden.setAlignment(buttonBar, javafx.geometry.Pos.CENTER);
        buttonBar.setPrefHeight(40.0);
        buttonBar.setPrefWidth(200.0);

        nieuwe.setMnemonicParsing(false);
        nieuwe.setText("Maak maaltijd");

        verwijderen.setMnemonicParsing(false);
        verwijderen.setText("Verwijderen");
        updatelistview.setMnemonicParsing(false);
        updatelistview.setText("Update-List");
        bewerken.setMnemonicParsing(false);
        bewerken.setText("Bewerken");

        BorderPaneOverzichtMijnmaaltijden.setMargin(buttonBar, new Insets(0.0));
        buttonBar.setPadding(new Insets(0.0, 20.0, 0.0, 0.0));
        BorderPaneOverzichtMijnmaaltijden.setBottom(buttonBar);

        BorderPaneOverzichtMijnmaaltijden.setAlignment(text, javafx.geometry.Pos.CENTER);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Je hebt de volgende maaltijd aangemaak:");
        BorderPaneOverzichtMijnmaaltijden.setTop(text);

        BorderPaneOverzichtMijnmaaltijden.setAlignment(tvBuurtbewoners, javafx.geometry.Pos.CENTER);
        tvBuurtbewoners.setPrefHeight(117.0);
        tvBuurtbewoners.setPrefWidth(600.0);

        colDatum.setId("Datum");
        colDatum.setPrefWidth(150.0);
        colDatum.setText("Datum");

        colTijd.setId("Tijd");
        colTijd.setMinWidth(0.0);
        colTijd.setPrefWidth(174.0);
        colTijd.setText("Tijd");

        tvBuurtbewoners.getColumns().add(colDatum);
        tvBuurtbewoners.getColumns().add(colTijd);
        buttonBar.getButtons().addAll(updatelistview, verwijderen, bewerken, nieuwe);
        System.out.println("telefoonnummer " + bewooner.getTelefoonnummer());
        String buurtbewoonertelefoonnummer = bewooner.getTelefoonnummer();
        System.out.println(buurtbewoonertelefoonnummer);
        showMaaltijden(bewooner);
        // toevoegen aan de root class
        BorderPaneNieuweMaaltijd.setVisible(false);
        BorderPaneBewerkenMaaltijd.setVisible(false);
        AnchorPaneMijnMaaltijden.getChildren().addAll(BorderPaneNieuweMaaltijd, BorderPaneOverzichtMijnmaaltijden, BorderPaneBewerkenMaaltijd);
        bewerken.disableProperty().bind(tvBuurtbewoners.getSelectionModel().selectedItemProperty().isNull());
        verwijderen.disableProperty().bind(tvBuurtbewoners.getSelectionModel().selectedItemProperty().isNull());
        // update van listview
        updatelistview.setOnAction(event -> {
            tvBuurtbewoners.getItems().clear();
            tvBuurtbewoners.getSelectionModel().clearSelection();
            showMaaltijden(bewooner);
        });
        //bewerken van maaltijden
        bewerken.setOnAction(event -> {
            System.out.println("Button bewerken is clicked!");
            Maaltijden maaltijden = tvBuurtbewoners.getSelectionModel().getSelectedItem();
            bewerkenMaaltijd bewerkenMaaltijd = new bewerkenMaaltijd(BorderPaneBewerkenMaaltijd, BorderPaneOverzichtMijnmaaltijden, bewooner, maaltijden);
            BorderPaneBewerkenMaaltijd.setVisible(true);
            BorderPaneOverzichtMijnmaaltijden.setVisible(false);
        });
        // verwijderen van maaltijden
        verwijderen.setOnAction(event -> {
            System.out.println("Button verwijderen is clicked!");
            try {
                con = DBCPDataSource.getConnection();
                Statement stat = con.createStatement();
                PreparedStatement pst = null;
                Maaltijden maaltijd = tvBuurtbewoners.getSelectionModel().getSelectedItem();
                // verwijderen van maaltijden
                int maaltijdID = maaltijd.maaltijdID;
                String strDeleteMaaltijden = "DELETE FROM maaltijden WHERE maaltijdID =?";
                pst = con.prepareStatement(strDeleteMaaltijden);
                pst.setInt(1, maaltijdID);
                int result1 = pst.executeUpdate();

                // verwijderen van aanmeldigen
                String strDeleteAanmelding = "DELETE FROM aanmeldingen WHERE maaltijdID =?";
                pst = con.prepareStatement(strDeleteAanmelding);
                pst.setInt(1, maaltijdID);
                int result2 = pst.executeUpdate();

                if (result1 == 1) {
                    tvBuurtbewoners.getItems().clear();
                    tvBuurtbewoners.getSelectionModel().clearSelection();
                    showMaaltijden(bewooner);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Maaltijd verwijderd");
                    alert.setHeaderText(null);
                    alert.setContentText("De maaltijd is verwijderd. en aantal aanmeldigen "+result2+"");
                    alert.showAndWait();
                }

                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TabMaaltijdOverzicht.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        nieuwe.setOnAction(event -> {
            BorderPaneNieuweMaaltijd.setVisible(true);
            BorderPaneOverzichtMijnmaaltijden.setVisible(false);
        });
    }
    // ophalen van maaltijden

    public ObservableList<Maaltijden> getMijnMaaltijden(String buurtbewoonertelefoonnummer) {

        ObservableList<Maaltijden> MaaltijdenList = FXCollections.observableArrayList();
        try {
            Connection conn = getConnection();
            String query = "Select buurtmaaltijd.maaltijden.maaltijdID, buurtmaaltijd.buurtbewoners.*, buurtmaaltijd.maaltijden.datum, buurtmaaltijd.maaltijden.tijd, buurtmaaltijd.buurtbewoners.naam As naam1, buurtmaaltijd.maaltijden.telefoonnummer As telefoonnummer1 From buurtmaaltijd.buurtbewoners Inner Join buurtmaaltijd.maaltijden On buurtmaaltijd.buurtbewoners.telefoonnummer = buurtmaaltijd.maaltijden.telefoonnummer WHERE maaltijden.telefoonnummer='" + buurtbewoonertelefoonnummer + "'";
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Maaltijden maaltijden;
            while (rs.next()) {
                int maaltijdID = rs.getInt("maaltijdID");
                String telefoonnummer = rs.getString("telefoonnummer");
                String datum = rs.getString("datum");
                String tijd = rs.getString("tijd");
                String naam = rs.getString("naam");
                // array maaltijden
                maaltijden = new Maaltijden(maaltijdID, telefoonnummer, datum, tijd, naam);

                MaaltijdenList.add(maaltijden);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return MaaltijdenList;
    }

// toonen van maaltijden
    public void showMaaltijden(Buurtbewoners bewooner) {
        String buurtbewoonertelefoonnummer = bewooner.getTelefoonnummer();
        ObservableList<Maaltijden> list = getMijnMaaltijden(buurtbewoonertelefoonnummer);
        colDatum.setCellValueFactory(new PropertyValueFactory<Buurtbewoners, String>("datum"));
        colTijd.setCellValueFactory(new PropertyValueFactory<Buurtbewoners, String>("tijd"));
        tvBuurtbewoners.setItems(list);
        System.out.println("Show maaltijden is run");
    }

}
