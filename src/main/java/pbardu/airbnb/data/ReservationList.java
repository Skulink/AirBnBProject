package pbardu.airbnb.data;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import pbardu.airbnb.logements.Logement;
import pbardu.airbnb.reservations.Reservation;
import pbardu.airbnb.reservations.Sejour;
import pbardu.airbnb.reservations.SejourCourt;
import pbardu.airbnb.reservations.SejourLong;
import pbardu.airbnb.utilisateurs.Voyageur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.chrono.JapaneseDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class ReservationList extends JPanel {
    private JList<String> listDesReservations;
    private JList<String> listDesLogements;
    private final ReservationList that = this;
    private List<Logement> list = AirBnBData.getInstance().getLogements();
    private JDateChooser jDateChooser = new JDateChooser();
    private Date dateArrivee = new Date();
    private int resultNbNuit;
    private int resultNbVoyageur;

    private int ageVoyageur;
    //Constructeur
    public ReservationList() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        String[] data = new String[list.size()];
        // Pour tous les éléments dans la list "list"
        for (int i = 0; i < list.size(); i++) {
            Logement logement = list.get(i);
            // On converti le logement en chaine de caractère
            String s = "<html>" + logement.toString() + "</html>";
            data[i] = s;
        }

        JPanel panelListLogement = new JPanel();
        panelListLogement.setLayout(new FlowLayout(FlowLayout.CENTER));
        listDesLogements = new JList<>(data);
        listDesLogements.setVisibleRowCount(1);
        JScrollPane scrollPane = new JScrollPane(listDesLogements);
        panelListLogement.add(new JLabel("Choisissez votre logement"));
        panelListLogement.add(scrollPane);


        this.add(panelListLogement);

        JPanel panelDate = new JPanel();
        panelDate.setLayout(new FlowLayout(FlowLayout.CENTER));

        jDateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                dateArrivee = jDateChooser.getDate();

            }
        });

        System.out.println(dateArrivee);
        panelDate.add(new JLabel("Choisissez votre date d'arrivée : "));
        panelDate.add(jDateChooser);

        this.add(panelDate);

        JPanel panelNbNuits = new JPanel();
        panelNbNuits.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNbNuits.add(new JLabel("Choisissez votre nombre de nuits"));
        JTextField nbNuits = new JTextField(10);
        panelNbNuits.add(nbNuits);
        this.add(panelNbNuits);

        if (nbNuits.getText().trim().length() > 0){

            resultNbNuit = Integer.parseInt(nbNuits.getText());
        }



        JPanel panelNbVoyageurs = new JPanel();
        panelNbVoyageurs.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNbVoyageurs.add(new JLabel("Choisissez le nombre de voyageurs : "));
        JTextField nbVoyageur = new JTextField(10);
        panelNbVoyageurs.add(nbVoyageur);
        this.add(panelNbVoyageurs);



        if (nbVoyageur.getText().trim().length()>0){

            resultNbVoyageur = Integer.parseInt(nbVoyageur.getText());
        }



        JPanel panelNomVoyageur = new JPanel();
        panelNomVoyageur.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNomVoyageur.add(new JLabel("Votre nom : "));
        JTextField textFieldNomVoyageur = new JTextField(10);
        panelNomVoyageur.add(textFieldNomVoyageur);
        this.add(panelNomVoyageur);

        String nomVoyageur = textFieldNomVoyageur.getText();

        JPanel panelPrenomVoyageur = new JPanel();
        panelPrenomVoyageur.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelPrenomVoyageur.add(new JLabel("Votre Prenom : "));
        JTextField textFieldPrenomVoyageur = new JTextField(10);
        panelPrenomVoyageur.add(textFieldPrenomVoyageur);
        this.add(panelPrenomVoyageur);

        String prenomVoyageur = textFieldPrenomVoyageur.getText();

        JPanel panelAgeVoyageur = new JPanel();
        panelAgeVoyageur.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelAgeVoyageur.add(new JLabel("Votre Age : "));
        JTextField textFieldAgeVoyageur = new JTextField(10);
        panelAgeVoyageur.add(textFieldAgeVoyageur);
        this.add(panelAgeVoyageur);



        if (textFieldAgeVoyageur.getText().trim().length()>0){

            ageVoyageur = Integer.parseInt(textFieldAgeVoyageur.getText());
        }

        JPanel panelButtonReserver = new JPanel();
        panelButtonReserver.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton buttonReserver = new JButton("Je reserve !");

        buttonReserver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LogementList listresult = new LogementList(true);

                Logement logementresult = listresult.getSelectedLogement();


                Sejour sejour = new SejourCourt(dateArrivee,logementresult, resultNbNuit, resultNbVoyageur);
                System.out.println(sejour.getNbNuits());
                Voyageur voyageur = new Voyageur(nomVoyageur,prenomVoyageur,ageVoyageur);
                Reservation reservation = new Reservation(sejour,voyageur);


            }
        });
        panelButtonReserver.add(buttonReserver);
        this.add(panelButtonReserver);



    }


}