package pbardu.airbnb.data;

import pbardu.airbnb.utilisateurs.Hote;

import javax.swing.*;
import java.util.List;

public class HoteList extends JPanel {
    private JList<String> listDesHotes;

    //Constructeur
    public HoteList() {

        List<Hote> list = AirBnBData.getInstance().getHotes();

        /*
         Version Java 8 Stream API
         String[] data = list.stream().map(Object::toString).toArray(String[]::new)
         */

        // Création d'un tableau de la même taille que la list "list"
        String[] data = new String[list.size()];
        // Pour tous les éléments dans la list "list"
        for (int i = 0; i < list.size(); i++) {
            Hote hote = list.get(i);
            // On converti le logement en chaine de caractère
            String s = hote.toString();
            data[i] = s;
        }

        listDesHotes = new JList<>(data);
        this.add(listDesHotes);
    }

}
