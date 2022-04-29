package com.mycompany.BuurtMaaltijden;

public class Maaltijden {

    public int maaltijdID;
    public String telefoonnummer;
    public String datum;
    public String tijd;
    public String naam;

    public Maaltijden(int maaltijdID, String telefoonnummer, String datum, String tijd, String naam) {
        this.maaltijdID = maaltijdID;
        this.telefoonnummer = telefoonnummer;
        this.datum = datum;
        this.tijd = tijd;
        this.naam = naam;
    }

    public int getMaaltijdID() {
        return maaltijdID;
    }

    public void setMaaltijdID(int maaltijdID) {
        this.maaltijdID = maaltijdID;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

}
