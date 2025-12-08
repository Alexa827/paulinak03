package Hotel;

import javax.swing.*;
import java.util.ArrayList;

public class HotelBuchung extends JFrame{

    private JPanel mainJPanel;
    private JTextField anzahlPersonentextField2;
    private JRadioButton fruestueckjaRadioButton;
    private JRadioButton fruestueckNeinRadioButton;
    private JTextArea ListetextArea1;
    private JButton buchnungSpeichernButton;
    private JComboBox zimemrAuswahlcomboBox1;
    private JLabel preisJLabel;
    private JLabel filterJLabel;
    private JLabel fruestueckJLabel;
    private JLabel anzahlPersonenJLabel;
    private JLabel zimmerAuswahlJLabel;
    private JTextField preisErgebnistextField1;
    private JTextField nametextField1;

    private liste<Zimmer> zimmerListe = new ArrayList<>();

    //Konstruktor:
    public HotelBuchung (){
        setTitle("Hotelbuchung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);
        setContentPane(mainJPanel);
        setVisible(true);

       void initObjekte; (){
        zimmerListe.add("Hotel");

    }


    public static void main (String[] args){
        new HotelBuchung();
    }

}

//die Methode, die den preis berechnet (aus Nächte und Frühstück)
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
            return preisProNacht;

        }

         */
