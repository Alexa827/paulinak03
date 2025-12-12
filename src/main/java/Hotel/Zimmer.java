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

    public double berechnePreis() {
        double gesamt = preisProNacht * naechteanzahl;
// hier mit fruehstück direkt, somit wird der endgültige preis berechnet
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

    //Ausgabe verschönern von Array Liste: (hier, weil HotelBuchung weiß nicht wie Objekte aussehen sollen, nur Klasse selbst)
    @Override
    public String toString() {
        return "\nVor- und Nachname: " + name +
                "\nZimmerart: " + zimmerArt +
                "\nNächteanzahl: " + naechteanzahl +
                "\nFrühstück: " + fruestueck +
                "\nPreis Pro Nacht: " + preisProNacht;

    }
}



