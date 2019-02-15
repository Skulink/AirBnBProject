package pbardu.airbnb.data;

import pbardu.airbnb.logements.Logement;
import pbardu.airbnb.reservations.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ReservationList extends JPanel {
    private JList<String> listDesReservations;
    private JList<String> listDesLogements;
    private final ReservationList that = this;
    private List<Logement> list = AirBnBData.getInstance().getLogements();


    //Constructeur
    public ReservationList() {

        this.setLayout(new BorderLayout());

        String[] data = new String[list.size()];
        // Pour tous les éléments dans la list "list"
        for (int i = 0; i < list.size(); i++) {
            Logement logement = list.get(i);
            // On converti le logement en chaine de caractère
            String s = logement.toString();
            data[i] = s;
        }

        listDesLogements = new JList<>(data);
        JScrollPane scrollPane = new JScrollPane(listDesLogements);
        this.add(scrollPane);



    }
}