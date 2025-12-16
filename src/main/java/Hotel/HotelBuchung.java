package Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HotelBuchung extends JFrame {


    private JPanel mainJPanel;
    private JTextField naechteanzahltextField2;
    private JRadioButton fruestueckjaRadioButton;
    private JRadioButton fruestueckNeinRadioButton;
    private JTextArea listetextArea1;
    private JButton buchnungSpeichernButton;
    private JComboBox zimmerAuswahlcomboBox1;
    private JLabel preisJLabel;
    private JLabel fruestueckJLabel;
    private JLabel naechteanzahlJLabel;
    private JLabel zimmerAuswahlJLabel;
    private JTextField nametextField1;
    private JButton minusAnzahlPersonenbutton1;
    private JButton plusAnzahlPersonenbutton2;
    private JLabel preisBerechnetJLabel;
    private JButton buchungenmitFruestueckbutton1;
    private JButton alleBuchungenanzeigenbutton1;

    private ArrayList<Zimmer> zimmerListe = new ArrayList<>();

    //Konstruktor:
    public HotelBuchung() {
        setTitle("Hotelbuchung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setContentPane(mainJPanel);
        setVisible(true);


        //füllt Liste, bevor Benutzer diese in GUI sieht, ohne sieht der Benutzer nichts
        initObjekte();

        //ComboBox befüllen mit einfachen Strings:
        zimmerAuswahlcomboBox1.addItem("Einzelzimmer");
        zimmerAuswahlcomboBox1.addItem("Doppelzimmer");
        zimmerAuswahlcomboBox1.addItem("Familienzimmer");

        //Früstück standartmäßig auf Ja stellen, falls nichts anderes ausgewählt wird
        ButtonGroup fruestueck = new ButtonGroup();
        fruestueck.add(fruestueckjaRadioButton);
        fruestueck.add(fruestueckNeinRadioButton);

        fruestueckjaRadioButton.setSelected(true);



//Gesamtpreis wird geändert bzw. aktualisiert, wenn bei Frühstücj ja oder nein ausgewählt wird
        fruestueckjaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gesamtPreis();
            }
        });

        fruestueckNeinRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gesamtPreis();
            }
        });


        //Counter für die Anzahl an Nächte (Minus)
        minusAnzahlPersonenbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Zahl von String zu int
                int counter = Integer.parseInt(naechteanzahltextField2.getText());
                if (counter > 1) {
                    //Zahl, soll eins nach unten zählen
                    counter--;
                }
                //Zahl wieder von int zu String
                naechteanzahltextField2.setText(String.valueOf(counter));
                gesamtPreis();
            }
        });
//Counter Plus
        plusAnzahlPersonenbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Zahl von String zu int
                int counter = Integer.parseInt(naechteanzahltextField2.getText());

                //Hier wird ein Hinweis angezeigt, wenn die max. Nächteanzahl überschritten wird
                //hier bedeutet this = das JFrame, 1.Text = Nachricht und 2.Text ist das Fenstertitel
                if (counter < 30) {
                    counter++;
                } else {
                    JOptionPane.showMessageDialog(HotelBuchung.this, "Es können maximal 30 Nächte gebucht werden!", "Hinweis", JOptionPane.INFORMATION_MESSAGE); //Das Information_Message ich der Ikon-Typ
                }

                //Zahl wieder von int zu String
                naechteanzahltextField2.setText(String.valueOf(counter));

                gesamtPreis(); //dadurch wird die Berechnung neu gemacht bei Änferungen
            }
        });


        //Preis berechnen, wenn einer der Zimmer angewählt ist, muss inerhalb des Konstruktors stehen
        zimmerAuswahlcomboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gesamtPreis();
            }
        });
        gesamtPreis();
        setVisible(true);

        buchnungSpeichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //hier erstmal prüfen, ob überhaupt ein Name eingegeben wurde, sonst Fehlermeldung
                String name = nametextField1.getText().trim();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(HotelBuchung.this, "Bitte einen Namen eingeben!", "Hinweis", JOptionPane.INFORMATION_MESSAGE);
                }

                String zimmerArt = (String) zimmerAuswahlcomboBox1.getSelectedItem();
                boolean fruestueck = fruestueckjaRadioButton.isSelected();

                int naechte;
                try {
                    naechte = Integer.parseInt(naechteanzahltextField2.getText());
                    if (naechte < 1)
                        naechte = 1; //heißt: wenn man weniger als 1 eingibt, wird es automatisch auf 1 gesetzt
                    if (naechte > 30)
                        naechte = 30; // heißt: wenn man mehr als 30 eingibt, wird es automatisch zurück auf "max" 30 gesetzt
                } catch (NumberFormatException exception) {
                    naechte = 1;
                    naechteanzahltextField2.setText("1");
                }

                //hier: Preis pro Nacht wird für Speicher Button bestimmt
                double preisPronacht = berechnePreisProNacht(zimmerArt);

                //Hier: für SpeicherButton wird ZimmerObjekt erstellt und gespeichert
                Zimmer zimmer = new Zimmer(name, zimmerArt, naechte, fruestueck, preisPronacht);
                zimmerListe.add(zimmer);

                //hier: wird Textarea aktualisiert, sodass Daten hinzugefügt werrden
                updateTextArea(zimmerListe);

                //Eingabefelder wieder auf Anfang setzten
                nametextField1.setText("");
                naechteanzahltextField2.setText("1");
                fruestueckjaRadioButton.setSelected(true);
                zimmerAuswahlcomboBox1.setSelectedIndex(0);
                preisBerechnetJLabel.setText("62.00 € für 1 Nacht");

                //ein Fenster, der aufploppt, um zu zeigen, dass die Buchung bestätigt wurde und gespeichert
                JOptionPane.showMessageDialog(HotelBuchung.this, "Buchung wurde erfolgreich gespeichert!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

        });

//Aktion Listener Filter für Buchungen mit Frühstück
        buchungenmitFruestueckbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Neue Liste nur mit Frühstück
                ArrayList<Zimmer> buchungenMitFruehstueck = new ArrayList<>();
                for (Zimmer zimmer : zimmerListe) {
                    if (zimmer.hatFruestueck()) {
                        buchungenMitFruehstueck.add(zimmer);
                    }
                }

                // TextArea aktualisieren mit gefilterter Liste
                updateTextArea(buchungenMitFruehstueck);
            }
        });

//Alle Buchungen können durch Button wieder angezeigt werden
        alleBuchungenanzeigenbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               updateTextArea(zimmerListe);
            }
        });
    }

    //Methode mit der man Zimmerart auswählt und der Preis pro Nacht bestimmt wird
    public double berechnePreisProNacht (String zimmerAuswahlcomboBox1){
        if ("Einzelzimmer".equals(zimmerAuswahlcomboBox1)){
            return 50.00;
        }   else if ("Doppelzimmer".equals(zimmerAuswahlcomboBox1)) {
            return 120.00;
        }   else if ("Familienzimmer".equals(zimmerAuswahlcomboBox1)) {
            return 180.00;
        } else {
            return 50.00;
        }

    }

    //hier Methode um Frhstück dazuzurechnen , wenn "ja" gewählt wird
    private void gesamtPreis() {

        String zimmerArt = (String) zimmerAuswahlcomboBox1.getSelectedItem();
        double preisProNacht = berechnePreisProNacht(zimmerArt);

        //try catch jetzt anwenden, weil der Benutzer alles eingeben kann, deshalb müssen wir jetzt die fehler auffangen und direkt beheben: Try bedeutet hier, dass der Computer versucht die eingabe in Zahl zu ändern und catch fägt den fehler ab
        int naechte;
        try {
            naechte = Integer.parseInt(naechteanzahltextField2.getText());
        } catch (NumberFormatException ex) {
            naechte = 1;
            naechteanzahltextField2.setText("1");
        }
        //Begrenzung bei manueller Eingabe der Nächte,  //Hier wird ein Hinweis angezeigt, wenn die max. Nächteanzahl überschritten wird
        if (naechte > 30){
            naechte = 30;
            naechteanzahltextField2.setText("30");

            JOptionPane.showMessageDialog (this, "Es können maximal 30 Nächte gebucht werden!","Hinweis", JOptionPane.INFORMATION_MESSAGE);
        }


        //hier wird Frühstück pro nacht bestimmt (je nach Zimmerart anderer Preis)
        double fruehstueckProNacht = 0.0;
        if (fruestueckjaRadioButton.isSelected()) {
            if ("Einzelzimmer".equals(zimmerArt)){
                fruehstueckProNacht = 12.0;
            } else if ("Doppelzimmer".equals(zimmerArt)){
                fruehstueckProNacht = 24.0;
            } else if ("Familienzimmer".equals(zimmerArt)) {
                fruehstueckProNacht = 40.0;
            }
        }

        //hier berechnet man den Endpreis (Zimmerart + eingegebene Nächteanzahl + Frühstück)
        double gesamtPreis = (preisProNacht + fruehstueckProNacht) * naechte;
// hinzugefügt im Label zum ausgeben (also die Ausgabe)
        if(naechte == 1){
            preisBerechnetJLabel.setText(gesamtPreis + " € für " + naechte + " Nacht");
        }else{
            preisBerechnetJLabel.setText(gesamtPreis + " € für " + naechte + " Nächte");
        }

    }


        //Einfügen von min. drei Objekten zur Array Liste:
        public void initObjekte () {
            zimmerListe.add(new Zimmer("Thomas Müller", "Einzelzimmer", 1,true, 50.00));
            zimmerListe.add(new Zimmer("Thomas Gottschalk", "Doppelzimmer", 2, true, 120.00));
            zimmerListe.add(new Zimmer("Heidi Klum", "Familienzimmer", 10, false, 20.00));
            zimmerListe.add(new Zimmer("Felix Lobrecht", "Doppelzimmer", 2, true, 150.00));

            updateTextArea(zimmerListe);
        }

        //Methode, damit sie aufgerufen werden kann, auch wenn man etwas hinzufügen möchte
        private void updateTextArea(ArrayList<Zimmer> liste) {
            String gesamtText = "";

            //Einfügen der bisherigen Liste in das Ausgabefelt
            for (Zimmer zimmer : liste) {
                String einZimmerText = zimmer.toString();
                gesamtText += einZimmerText;
                gesamtText += "\n=================";
            }

            listetextArea1.setText(gesamtText);
        }

        public static void main (String[]args){
            new HotelBuchung();
        }
    }





