Hotelbuchung – Projektarbeit Programmiertechnik IMUK I

Projektübersicht:
Dieses Projekt entstand im Rahmen der Projektarbeit im Fach Programmiertechnik (WiSe 2025/26) an der Hochschule Neu-Ulm.

Ziel ist die Entwicklung eines Java-Programms mit grafischer Benutzeroberfläche (Swing), mit dem Hotelbuchungen erfasst, gespeichert und gefiltert werden können.  
Die Anwendung ermöglicht das Erzeugen von Objekten, deren Verwaltung in einer Liste sowie die Anzeige und Filterung über die GUI.


Gruppenmitglieder
- Paulina Kulzer 
- Alexandra Eszter Takacs

Hotelbuchung (Objekt):

Die zentrale Klasse modelliert eine Hotelbuchung mit folgenden Attributen:
- Name des Gastes (String)
- Zimmerart (String)
- Anzahl der Nächte (int)
- Frühstück gebucht (boolean)
- Preis pro Nacht (double)

Zusätzlich enthält die Klasse folgende Methoden: 
- Preisberechnung
- Ausgabe der Buchungsinformationen (`toString`)
- Filterung/Auswertung der Buchungen

Grafische Benutzeroberfläche (Swing):
- Eingabe von Name und Zimmerart (Textfeld & Combobox)
- Auswahl der Nächte über Plus-/Minus-Buttons
- Auswahl, ob Frühstück gebucht wird
- Automatische Berechnung und Anzeige des Gesamtpreises
- Speichern der Buchung per Button
- Anzeige aller gespeicherten Buchungen in einer TextArea
- Filterung (Buchungen mit Frühstück)

Nach dem Speichern einer Buchung erscheint ein Info-Fenster zur Bestätigung.



Projektstruktur

```text
 ProjektarbeitProgrammiertechnik
 ┣ src
 ┃ ┣  model
 ┃ ┃ ┗  Zimmer.java
 ┃ ┣  gui
 ┃ ┃ ┗  HotelGUI.java
 ┃ ┣  test
 ┃ ┃ ┗  ZimmerTest.java
 ┣  UML_Klassendiagramm.pdf
 ┣  README.md

JUnit Test

Für die zentrale Logik (z. B. Preisberechnung / Filtermethoden) wurde ein JUnit-Test implementiert.
Dieser überprüft die korrekte Funktionsweise der Methoden der Modellklasse.

Initialisierung

Beim Start des Programms werden in der Methode:

public void initObjekte()
drei Beispielbuchungen erzeugt und in einer Liste gespeichert, sodass die Anwendung direkt nutzbar ist.

Exception Handling

Falsche Eingaben (Buchstaben statt Zahlen) werden abgefangen

Benutzer erhalten eine Fehlermeldung über das Dialogfenster

Video & UML

Ein Lehrvideo (3 Minuten) erklärt die Projektidee, den Aufbau und die Funktionsweise

Ein UML-Klassendiagramm visualisiert die Objektstruktur

Verwendete Technologien
Java
Java Swing
JUnit
IntelliJ IDEA
Git & GitHub
