package pbardu.airbnb.data;

import pbardu.airbnb.reservations.Reservation;
import pbardu.airbnb.utilisateurs.Hote;

import javax.swing.*;
import java.util.List;

public class ReservationList extends JPanel{
    private JList<String> listDesReservations;

    //Constructeur
    public ReservationList() {

        //List<Reservation> list = AirBnBData.getInstance();

        /*
         Version Java 8 Stream API
         String[] data = list.stream().map(Object::toString).toArray(String[]::new)
         */

        // Création d'un tableau de la même taille que la list "list"
       // String[] data = new String[list.size()];
        // Pour tous les éléments dans la list "list"
       // for(int i = 0; i < list.size(); i++) {
       //     Reservation reservation = list.get(i);
            // On converti le logement en chaine de caractère
       //     String s = reservation.toString();
       //     data[i] = s;
        }

       // listDesReservations = new JList<>(data);
       // this.add(listDesReservations);

    }

//}
