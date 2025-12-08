package Hotel;

import java.util.ArrayList;

public class Zimmer {
//3 Attribute
    private String name;
    private String zimmerArt;
    private int personenanzahl;
    private double preisProNacht;

    public Zimmer(String name, String zimmerArt, int personenanzahl, double preisProNacht) {
        this.name = name;
        this.zimmerArt = zimmerArt;
        this.personenanzahl = personenanzahl;
        this.preisProNacht = preisProNacht;
    }

    public double berechnePreis(int naechte, boolean fruehstueck) {
        double gesamt = preisProNacht * naechte;

        if (fruehstueck) {
            gesamt += 10 * naechte;
        }
        return gesamt;
    }
    public String getZimmerArt() {
        return zimmerArt;
    }
    public int getPersonenanzahl(){
        return personenanzahl;
    }
    public double getPreisProNacht(){
        return preisProNacht;

    }


}


