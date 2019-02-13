package pbardu.airbnb.data;

import pbardu.airbnb.data.AirBnBData;
import pbardu.airbnb.logements.Logement;

import javax.swing.*;
import java.util.List;


/**
 * Classe représentant une liste de logement
 * Extends JPanel pour son utilisation
 */
public class LogementList extends JPanel {

    private JList<String> listDesLogements;

    //Constructeur
    public LogementList() {

        List<Logement> list = AirBnBData.getInstance().getLogements();

        /*
         Version Java 8 Stream API
         String[] data = list.stream().map(Object::toString).toArray(String[]::new)
         */

        // Création d'un tableau de la même taille que la list "list"
        String[] data = new String[list.size()];
        // Pour tous les éléments dans la list "list"
        for(int i = 0; i < list.size(); i++) {
            Logement logement = list.get(i);
            // On converti le logement en chaine de caractère
            String s = logement.toString();
            data[i] = s;
        }

        listDesLogements = new JList<>(data);
        this.add(listDesLogements);
    }

}
