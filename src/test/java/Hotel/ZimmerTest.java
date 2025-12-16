package Hotel;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ZimmerTest {

    //Generiert über Klasse Zimmer

    @org.junit.jupiter.api.Test
    void testberechnePreis() {
        //Erstellen von einem Simulationszimmer
        Zimmer einzelzimmer = new Zimmer("Test Zimmer", "Einzelzimmer", 3, true, 50);
        Zimmer doppelzimmer = new Zimmer("Test Zimmer", "Doppelzimmer", 2, false, 120);
        Zimmer familienzimmer = new Zimmer("Test Zimmer", "Familienzimmer", 5, false, 180);
        //Aufrufen der Methode, die getestet werden soll
        double ergebnis1= einzelzimmer.berechnePreis();
        double ergebnis2 = doppelzimmer.berechnePreis();
        double ergebnis3 = familienzimmer.berechnePreis();

        // expected (was erwartet man): Erhofftes Ergebnis (im Kopf gerechnet); actual (das bekommt man): berechnetes Ergebis von der Methode
        // 0.01 Toleranzbereich für den Ungenauigkeits Bereich, ist speziell, wei wir mit einem Double getestet haben
        //Tests sind nie für den Benutzer, nur für den Entwickler
        assertEquals(186.00, ergebnis1, 0.01);
        assertEquals(240.00, ergebnis2, 0.01);
        assertEquals(900.00, ergebnis3, 0.01);
    }
}