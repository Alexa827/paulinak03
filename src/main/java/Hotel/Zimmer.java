package Hotel;

import javax.swing.*;
import java.util.ArrayList;
public class Zimmer extends JFrame {

    private String name;
    private String zimmerArt;
    private int naechteanzahl;
    private boolean fruestueck;
    private double preisProNacht;

//Konstruktor
    public Zimmer(String name, String zimmerArt, int naechteanzahl, boolean fruestueck, double preisProNacht) {
        this.name = name;
        this.zimmerArt = zimmerArt;
        this.naechteanzahl = naechteanzahl;
        this.fruestueck = fruestueck;
        this.preisProNacht = preisProNacht;
    }

    public double berechnePreis() {
        double gesamt = preisProNacht * naechteanzahl;

// hier mit Fruehstück direkt, somit wird der endgültige Preis berechnet
        if (fruestueck) {
            double fruestueckPreis = 0;

            if ("Einzelzimmer".equals(zimmerArt)) {
                fruestueckPreis = 12.0;
            } else if ("Doppelzimmer".equals(zimmerArt)) {
                fruestueckPreis = 24.0;
            } else if ("Familienzimmer".equals(zimmerArt)) {
                fruestueckPreis = 40.0;
            }

            gesamt += fruestueckPreis * naechteanzahl;
        }
        return gesamt;
    }

    public boolean hatFruestueck(){
        return fruestueck;
    }

    // Formatiert die Ausgabe der ArrayList hier, da HotelBuchung nur die Klasse kennt
    @Override
    public String toString() {
        //Ausgabe von Frühstück statt true/false jetzt Ja/Nein
        String fruestueckstext;
        if(fruestueck == true){
        fruestueckstext = "Ja";
        }else {
        fruestueckstext = "Nein";
        }
        return "\nVor- und Nachname: " + name +
                "\nZimmerart: " + zimmerArt +
                "\nNächteanzahl: " + naechteanzahl +
                "\nFrühstück: " + fruestueckstext +
                "\nPreis Pro Nacht: " + preisProNacht + " €";

    }
}



