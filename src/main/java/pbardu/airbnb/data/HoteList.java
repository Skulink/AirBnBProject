package pbardu.airbnb.data;

import pbardu.airbnb.utilisateurs.Hote;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HoteList extends JPanel {
    private JList<String> listDesHotes;


    //Constructeur
    public HoteList(boolean withoutAside) {
        this.setLayout(new BorderLayout());
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
        listDesHotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(listDesHotes,BorderLayout.CENTER);
        if(!withoutAside) {
            this.buildAside();
        }
    }

    public HoteList() {
       this(false);
    }


    public void buildAside(){
        JPanel mainAside = new JPanel();
        mainAside.add(new JButton("Ajouter"));
        mainAside.add(new JButton("Supprimer"));
        this.add(mainAside, BorderLayout.EAST);
    }

    public Hote getSelectedHote() {
        List<String> selection = listDesHotes.getSelectedValuesList();
        if(selection.size() > 0) {
            String hoteString = selection.get(0);
            List<Hote> list = AirBnBData.getInstance().getHotes();

            /*
            Version 8 BG ©Jheissler
            return list.stream()
                .filter(hote -> hote.toString().equals(hoteString)) // Ne garde que ceux qui respecte le test
                .findFirst() // On recupère le premier ou aucun Optional<Hote>
                .orElseGet(null); // On récupère cette valeur ou null si elle n'existe pas
            */

            for(Hote h : list) {
                if(h.toString().equals(hoteString)) {
                    return h;
                }
            }
            return null;
        } else {
            return null;
        }

    }
    public void setListDesHotes(JList<String> listDesHotes) {
        this.listDesHotes = listDesHotes;
    }

}
