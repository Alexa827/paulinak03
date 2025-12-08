package Hotel;

import javax.swing.*;
import java.util.ArrayList;

public class HotelBuchung extends JFrame{

    private JPanel mainJPanel;
    private JTextField anzahlPersonentextField2;
    private JRadioButton fruestueckjaRadioButton;
    private JRadioButton fruestueckNeinRadioButton;
    private JTextArea listetextArea1;
    private JButton buchnungSpeichernButton;
    private JComboBox zimmerAuswahlcomboBox1;
    private JLabel preisJLabel;
    private JLabel filterJLabel;
    private JLabel fruestueckJLabel;
    private JLabel anzahlPersonenJLabel;
    private JLabel zimmerAuswahlJLabel;
    private JTextField preisErgebnistextField1;
    private JTextField nametextField1;

   private ArrayList<Zimmer> zimmerListe = new ArrayList<>();

    //Konstruktor:
    public HotelBuchung (){
        setTitle("Hotelbuchung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);
        setContentPane(mainJPanel);
        setVisible(true);

        //füllt Liste, bevor Benutzer diese in GUI sieht ??
        initObjekte();

        //ComboBox befüllen mit einfachen Strings:
        zimmerAuswahlcomboBox1.addItem("Einzelzimmer");
        zimmerAuswahlcomboBox1.addItem("Doppelzimmer");
        zimmerAuswahlcomboBox1.addItem("Familienzimmer");

        //Eingabe aus Eingabefelder holen:
        String name = nametextField1.getText();
        double anzahlPersonen = Double.parseDouble(anzahlPersonentextField2.getText());


        }


    //Einfügen von min. drei Objekten zur Array Liste:
    public void initObjekte (){
        zimmerListe.add(new Zimmer("Thomas Müller","Einzelzimmer", 1, 50.00 ));
        zimmerListe.add(new Zimmer("Thomas Gottschalk","Doppelzimmer", 2, 100.00 ));
        zimmerListe.add(new Zimmer("Heidi Klum","Familienzimmer", 10, 1000.00 ));
        zimmerListe.add(new Zimmer("Felix Lobrecht","Doppelzimmer", 2, 150.00 ));

        //Einfügen der bisherigen Liste in das Ausgabefelt
        listetextArea1.setText(zimmerListe.toString());
    }


    public static void main (String[] args){
        new HotelBuchung();
    }

}


