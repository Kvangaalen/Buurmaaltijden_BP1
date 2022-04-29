// dit document is voor alle functie/methode..
package com.mycompany.BuurtMaaltijden;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

public class Methods {
    // voor het toonen van details buurtmaaltijden
    static void toonmaaltijden(BorderPane borderPaneDetailsbuurtmaaltijden, BorderPane borderPaneBuurtmaaltijden) {
        borderPaneDetailsbuurtmaaltijden.setVisible(true);
        borderPaneBuurtmaaltijden.setVisible(false);
    }
 // word niet meer gebruikt....
    static void allergieToInt(String allergie, Buurtbewoners bewooner) {
        try {
            Connection con = DBCPDataSource.getConnection();
            Statement stat = con.createStatement();
            String telefoonnummer = bewooner.getTelefoonnummer();
            // String strInsert = "DELETE FROM `buurtmaaltijd`.`allergie` WHERE ( allergie.telefoonnummer  = "+telefoonnummer+")";
            // stat.executeUpdate(strInsert);
            switch (allergie) {
                case "Gluten":
                    String strInsert1 = "insert into allergie1 (allergieID, telefoonnummer) values ( 1, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert1);
                    System.out.println(strInsert1);
                    break;
                case "Schaaldieren":
                    String strInsert2 = "insert into allergie (allergieID, telefoonnummer) values ( 2, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert2);
                    break;
                case "Eieren":
                    String strInsert3 = "insert into allergie (allergieID, telefoonnummer) values ( 3, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert3);
                    break;
                case "Vis":
                    String strInsert4 = "insert into allergie (allergieID, telefoonnummer) values ( 4, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert4);
                    break;
                case "Pinda":
                    String strInsert5 = "insert into allergie (allergieID, telefoonnummer) values ( 5, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert5);
                    break;
                case "Soja":
                    String strInsert6 = "insert into allergie (allergieID, telefoonnummer) values ( 6, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert6);
                    break;
                case "Lactose":
                    String strInsert7 = "insert into allergie (allergieID, telefoonnummer) values ( 7, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert7);
                    break;
                case "Noten ":
                    String strInsert8 = "insert into allergie (allergieID, telefoonnummer) values ( 8, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert8);
                    break;
                case "Selderij":
                    String strInsert9 = "insert into allergie (allergieID, telefoonnummer) values ( 9, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert9);
                    break;
                case "Mosterd":
                    String strInsert10 = "insert into allergie (allergieID, telefoonnummer) values ( 10, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert10);
                    break;
                case "Sesamzaad":
                    String strInsert11 = "insert into allergie (allergieID, telefoonnummer) values ( 11, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert11);
                    break;
                case "Zwaveldioxide":
                    String strInsert12 = "insert into allergie (allergieID, telefoonnummer) values ( 12, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert12);
                    break;
                case "Lupine ":
                    String strInsert13 = "insert into allergie (allergieID, telefoonnummer) values ( 13, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert13);
                    break;
                case "Weekdieren":
                    String strInsert14 = "insert into allergie (allergieID, telefoonnummer) values ( 14, " + telefoonnummer + ")";
                    stat.executeUpdate(strInsert14);
                    break;
            }
        } catch (SQLException se) {
            System.out.println("Error : " + se.getMessage());
        }
    }
    // deze functie zorgt er voor dat alle allergie worden opgehaalt uit de database.
    // daarna wordt door while-loop de allegie id uit db omgezet  naar een string en toegevoegd aan de listview overzichtallergie
    static void toonAllergie(Buurtbewoners bewooner, ListView overzichtAllergie) throws SQLException {
        Connection con = null;
        try {
            con = DBCPDataSource.getConnection();
            System.out.println("tel " + bewooner.getTelefoonnummer());
            String telefoonnummer = bewooner.getTelefoonnummer();
            String query = "SELECT * FROM allergie WHERE telefoonnummer = " + telefoonnummer + "";
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery(query);
            // while date 
            while (rs.next()) {
                String allergieID = rs.getString("allergieID");
                // Convret from int to string
                int allergieID_INT = Integer.parseInt(allergieID);
                // Allergie allergie = new Allergie(rs.getInt("gluten"), rs.getInt("Schaaldieren"), rs.getInt("Eieren"), rs.getInt("Vis"), rs.getInt("Pinda"), rs.getInt("Soja"), rs.getInt("lactose"), rs.getInt("Noten"), rs.getInt("Selderij"), rs.getInt("Mosterd"), rs.getInt("Sesamzaad"), rs.getInt("Zwaveldioxide"), rs.getInt("Lupine"), rs.getInt("Weekdieren"));
                // allergieList.add(allergie);
                switch (allergieID_INT) {
                    case 1:
                        overzichtAllergie.getItems().add("Gluten");
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
                        overzichtAllergie.getItems().add("Pinda");
                        break;
                    case 6:
                        overzichtAllergie.getItems().add("Soja");
                        break;
                    case 7:
                        overzichtAllergie.getItems().add("Lactose");
                        break;
                    case 8:
                        overzichtAllergie.getItems().add("Noten");
                        break;
                    case 9:
                        overzichtAllergie.getItems().add("Selderij");
                        break;
                    case 10:
                        overzichtAllergie.getItems().add("Mosterd");
                        break;
                    case 11:
                        overzichtAllergie.getItems().add("Sesamzaad");
                        break;
                    case 12:
                        overzichtAllergie.getItems().add("Zwaveldioxide");
                        break;
                    case 13:
                        overzichtAllergie.getItems().add("Lupine");
                        break;
                    case 14:
                        overzichtAllergie.getItems().add("Weekdieren");
                        break;
                }
            }
        } catch (NumberFormatException | SQLException ex) {
        } finally {
            if (con != null && !con.isClosed()) {
                con.close();
            }

        }
    }

    static void toonbuurtmaaltijd(ListView overzichtMaaltijden) {
        try {
            Connection con = DBCPDataSource.getConnection();
            ObservableList<Maaltijden> MaaltijdenList = FXCollections.observableArrayList();
            String query = ("Select buurtmaaltijd.buurtbewoners.naam, buurtmaaltijd.buurtbewoners.postcode, buurtmaaltijd.buurtbewoners.huisnummer, buurtmaaltijd.maaltijden.telefoonnummer, buurtmaaltijd.maaltijden.datum, buurtmaaltijd.maaltijden.tijd,   buurtmaaltijd.maaltijden.maaltijdID From buurtmaaltijd.buurtbewoners Inner Join buurtmaaltijd.maaltijden On buurtmaaltijd.maaltijden.telefoonnummer = buurtmaaltijd.buurtbewoners.telefoonnummer");
            Statement st;
            ResultSet result;
            st = con.createStatement();
            result = st.executeQuery(query);
            Maaltijden maaltijden;

            Callback<ListView<Maaltijden>, ListCell<Maaltijden>> cellFactory;
            cellFactory = new Callback<ListView<Maaltijden>, ListCell<Maaltijden>>() {
                public ListCell<Maaltijden> call(ListView<Maaltijden> p) {
                    final ListCell<Maaltijden> cell;
                    cell = new ListCell<Maaltijden>() {
                        {
                            super.setPrefWidth(200);
                        }

                        @Override
                        protected void updateItem(Maaltijden m, boolean bln) {
                            super.updateItem(m, bln);
                            if (m == null || bln) {
                                setGraphic(null);
                            } else {
                                LocalDateTime currentDateTime = LocalDateTime.now();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                String strcurrentDateTime = currentDateTime.format(formatter);
                                if (strcurrentDateTime.compareTo(m.datum)
                                        > 0) {
                                    System.out.println("strcurrentDateTime is after m.datum");
                                    setText(m.naam + " organiseert een buurtmaaltijd op " + m.datum + " om " + m.tijd + " uur. (verlopen)");
                                } else {
                                    setText(m.naam + " organiseert een buurtmaaltijd op " + m.datum + " om " + m.tijd + " uur.");
                                }
                            }
                        }
                    };
                    return cell;
                }
            };

            overzichtMaaltijden.setCellFactory(cellFactory);
            while (result.next()) {
                int maaltijdID = result.getInt("maaltijdID");
                String telefoonnummer = result.getString("telefoonnummer");
                String datum = result.getString("datum");
                String tijd = result.getString("tijd");
                String naam = result.getString("naam");

                // array maaltijden
                maaltijden = new Maaltijden(maaltijdID, telefoonnummer, datum, tijd, naam);
                // Arry toevoegen  aan ListView
                overzichtMaaltijden.getItems().add(maaltijden);
                MaaltijdenList.add(maaltijden);
                System.out.println(MaaltijdenList);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }




    
}
