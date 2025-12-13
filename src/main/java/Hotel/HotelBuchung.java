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

        //füllt Liste, bevor Benutzer diese in GUI sieht, ohne sieht der Benutzer nichts
        initObjekte();

        //ComboBox befüllen mit einfachen Strings:
        zimmerAuswahlcomboBox1.addItem("Einzelzimmer");
        zimmerAuswahlcomboBox1.addItem("Doppelzimmer");
        zimmerAuswahlcomboBox1.addItem("Familienzimmer");


        //Eingabe aus Eingabefelder holen:
        String name = nametextField1.getText();
        double naechteanzahl = Double.parseDouble(naechteanzahltextField2.getText());



        minusAnzahlPersonenbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Zahl von String zu int
                int counter = Integer.parseInt(naechteanzahltextField2.getText());
                if (counter > 1){
                    //Zahl, soll eins nach unten zählen
                    counter --;
                }
                //Zahl wieder von int zu String
                naechteanzahltextField2.setText(String.valueOf(counter));
            }
        });

        plusAnzahlPersonenbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Zahl von String zu int
                int counter = Integer.parseInt(naechteanzahltextField2.getText());
                //Zahl, soll eins nach oben zählen
                counter ++;
                //Zahl wieder von int zu String
                naechteanzahltextField2.setText(String.valueOf(counter));
            }
        });

        zimmerAuswahlcomboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hier die lokale Variable, die als wertespeicher dient
                String zimmerArt = (String) zimmerAuswahlcomboBox1.getSelectedItem();
                //wir nehmen die methode für zimmerArt
                double preisProNacht = berechnePreisProNacht(zimmerArt);
                //habe das Label neu hinzugefügt mit dem AusgabeText, wenn es durch die Methode berechnet wird
                preisBerechnetJLabel.setText(preisProNacht + " € pro Nacht");
            }
        });
    }

    //Methode mit der man Zimmerart auswählt und der Preis pro Nacht bestimmt wird
    public double berechnePreisProNacht (String zimmerAuswahlcomboBox1){
        if ("Enzelzimmer".equals(zimmerAuswahlcomboBox1)) {
            return 50.00;
        }   else if ("Doppelzimmer".equals(zimmerAuswahlcomboBox1)) {
            return 120.00;
        }   else if ("Familienzimmer".equals(zimmerAuswahlcomboBox1)) {
            return 180.00;
        } else {
            return 50.00;
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



