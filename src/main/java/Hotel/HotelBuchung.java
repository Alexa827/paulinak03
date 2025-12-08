package Hotel;

import javax.swing.*;

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

    //Konstruktor:
    public HotelBuchung (){
        setTitle("Hotelbuchung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,700);
        setContentPane(mainJPanel);
        setVisible(true);
    }


    public static void main (String[] args){
        new HotelBuchung();
    }

}
