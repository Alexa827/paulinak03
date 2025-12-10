package Hotel;

import javax.swing.*;
import java.util.ArrayList;
public class Zimmer extends JFrame {
    //3 Attribute
    private String name;
    private String zimmerArt;
    private int naechteanzahl;
    private boolean fruestueck;
    private double preisProNacht;


    public Zimmer(String name, String zimmerArt, int naechteanzahl, boolean fruestueck, double preisProNacht) {
        this.name = name;
        this.zimmerArt = zimmerArt;
        this.naechteanzahl = naechteanzahl;
        this.fruestueck = fruestueck;
        this.preisProNacht = preisProNacht;

    }

    public double berechnePreis(int naechteanzahl) {
        double gesamt = preisProNacht * naechteanzahl;

        // Frühstück entweder ja oder nein, wenn ja dann berechnet es 10 euro auf den preis pro nacht drauf
        if (fruestueck) {
            gesamt += 10 * naechteanzahl;
        }

        return gesamt;
    }

    //Ausgabe verschönern von Array Liste: (hier, weil HotelBuchung weiß nicht wie Objekte aussehen sollen, nur Klasse selbst)
    @Override
    public String toString() {
        return "\nVor- und Nachname: " + name +
                "\nZimmerart: " + zimmerArt +
                "\nNächteanzahl: " + naechteanzahl +
                "\nFrühstück: " + fruestueck +
                "\nPreis Pro Nacht: " + preisProNacht +
                "\n-------------------";

    }
}



