package Hotel;

import java.util.ArrayList;
public class Zimmer {
    //3 Attribute
    private String name;
    private String zimmerArt;
    private int personenanzahl;
    private boolean fruestueck;
    private double preisProNacht;

    public Zimmer(String name, String zimmerArt, int personenanzahl, double preisProNacht) {
        this.name = name;
        this.zimmerArt = zimmerArt;
        this.personenanzahl = personenanzahl;
        this.preisProNacht = preisProNacht;
    }

    //Ausgabe verschönern von Array Liste: (hier, weil HotelBuchung weiß nicht wie Objekte aussehen sollen, nur Klasse selbst)
    @Override
    public String toString() {
        return "\nVor- und Nachname: " + name +
                "\nZimmerart: " + zimmerArt +
                "\nPersonenanzahl: " + personenanzahl +
                "\nFrühtück: " + fruestueck +
                "\nPreisProNacht: " + preisProNacht +
                "\n-------------------";

    }
}



