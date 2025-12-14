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
    private JLabel filterJLabel;
    private JLabel fruestueckJLabel;
    private JLabel naechteanzahlJLabel;
    private JLabel zimmerAuswahlJLabel;
    private JTextField nametextField1;
    private JButton minusAnzahlPersonenbutton1;
    private JButton plusAnzahlPersonenbutton2;
    private JLabel preisBerechnetJLabel;

    private ArrayList<Zimmer> zimmerListe = new ArrayList<>();

    //Konstruktor:
    public HotelBuchung() {
        setTitle("Hotelbuchung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setContentPane(mainJPanel);
        setVisible(true);

        naechteanzahltextField2.setText("1");

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
                    counter ++;
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
    /*private double fruehstueckProNacht(String zimmerArt) {
        if (!fruestueckjaRadioButton.isSelected()) {
            return 0.0;
        }

        if ("Einzelzimmer".equals(zimmerArt)) return 12.0;
        if ("Doppelzimmer".equals(zimmerArt)) return 24.0;
        if ("Familienzimmer".equals(zimmerArt)) return 40.0;

        return 0.0;
    }*/



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
        preisBerechnetJLabel.setText(gesamtPreis + " € für " + naechte + "Nächte");

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

/*public double berechnePreis(int naechte, boolean fruehstueck) {
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
    return preisProNacht;*/



