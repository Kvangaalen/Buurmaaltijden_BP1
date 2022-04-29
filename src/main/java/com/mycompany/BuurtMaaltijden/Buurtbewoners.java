package com.mycompany.BuurtMaaltijden;

public class Buurtbewoners {

    private String telefoonnummer;
    private String naam;
    private String postcode;
    private int huisnummer;

    public Buurtbewoners(String telefoonnummer, String naam, String postcode, int huisnummer) {
        this.telefoonnummer = telefoonnummer;
        this.naam = naam;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
    }

    public String setTelefoonnummer() {
        return telefoonnummer;
    }

    public String getNaam() {
        return naam;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    


}
