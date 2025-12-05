package Hotel;

public class Hotel {

    //Attribute deklarieren:
    private String name;
    private String standort;
    private int anzahlSterne;
    private double preisProNacht;
    private boolean luxsushotel;

    //Konstruktor erstellen: (Initialisieren von Objektvariablen, Vorbereiten des Objekts für die Nutzung, Prüfen ob Objekte gültig erstellt wird)

    public Hotel(String name, String standort, int anzahlSterne, double preisProNacht, boolean luxsushotel) {
        this.name = name;
        this.standort = standort;
        this.anzahlSterne = anzahlSterne;
        this.preisProNacht = preisProNacht;
        this.luxsushotel = luxsushotel;
    }



    //Ist das Hotel ein Luxushotel. Ja, wenn Hotel mehr als drei Sterne hat oder mehr als 200€ pro Nacht kostet; nein, wenn beide Bedingungen nicht zutreffen


    //Kosten Pro Nacht, wenn es ein/kein Luxus Hotel ist. Kosten für den ganzen Aufenhaltsraum.

}
