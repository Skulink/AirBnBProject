package pbardu.airbnb.data;

import pbardu.airbnb.utilisateurs.Voyageur;

import javax.swing.*;
import java.util.List;

public class VoyageurList extends JPanel {
        private JList<String> listDesVoyageurs;

        //Constructeur
        public VoyageurList() {

            List<Voyageur> list = AirBnBData.getInstance().getVoyageurs();

        /*
         Version Java 8 Stream API
         String[] data = list.stream().map(Object::toString).toArray(String[]::new)
         */

            // Création d'un tableau de la même taille que la list "list"
            String[] data = new String[list.size()];
            // Pour tous les éléments dans la list "list"
             for(int i = 0; i < list.size(); i++) {
                 Voyageur voyageur = list.get(i);
            // On converti le logement en chaine de caractère
                String s = voyageur.toString();
                 data[i] = s;
        }

            listDesVoyageurs = new JList<>(data);
         this.add(listDesVoyageurs);

    }

}

