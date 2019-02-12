package pbardu.airbnb.data;

import pbardu.airbnb.logements.Appartement;
import pbardu.airbnb.logements.Logement;
import pbardu.airbnb.logements.Maison;
import pbardu.airbnb.utilisateurs.Hote;
import pbardu.airbnb.utilisateurs.Voyageur;

import java.util.ArrayList;

public final class AirBnBData {

    private static final AirBnBData INSTANCE = new AirBnBData();

    private final ArrayList<Hote> hotes;
    private final ArrayList<Voyageur> voyageurs;
    private final ArrayList<Logement> logements;

    private AirBnBData() {

        hotes = new ArrayList<>();
        voyageurs = new ArrayList<>();
        logements = new ArrayList<>();

        // Hotes
        hotes.add(new Hote("Bardu", "Peter", 30, 12));
        hotes.add(new Hote("Bardu", "Tom", 34, 12));
        hotes.add(new Hote("Albert", "Max", 33, 24));
        hotes.add(new Hote("Patrick", "Martin", 32, 12));
        hotes.add(new Hote("Jeanne", "Voisin", 26, 24));
        hotes.add(new Hote("Maurice", "Meunier", 46, 12));

        // Voyageurs
        voyageurs.add(new Voyageur("Albert", "Jean", 21));

        // Logements
        logements.add(new Maison(hotes.get(4), 100, "82 rue Colbert, 37000 Tours", 100, 4, 1000, true));
        logements.add(new Maison(hotes.get(1), 250, "84 rue Colbert, 37000 Tours", 80, 2, 2000, false));
        logements.add(new Maison(hotes.get(2), 80, "86 rue Colbert, 37000 Tours", 120, 2, 0, false));
        logements.add(new Appartement(hotes.get(1), 100, "85 rue Colbert, 37000 Tours", 100, 6, 0, 3));
        logements.add(new Maison(hotes.get(0), 40, "18 Bis rue Romain Rolland, 37230 Fondettes", 140, 10, 500, false));
        logements.add(new Maison(hotes.get(3), 35, "146 Rue George Sand, 59553 Cuincy", 120, 2, 0, false));
        logements.add(new Maison(hotes.get(5), 60, "13 Rue de la LibertÈ, 62800 LiÈvin", 90, 4, 2000, true));
        logements.add(new Appartement(hotes.get(2), 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20));
        logements.add(new Appartement(hotes.get(4), 35, "111 Rue Colbert, 37000 Tours", 42, 2, 12, 0));
    }

    public static AirBnBData getInstance() {
        return INSTANCE;
    }

    public ArrayList<Hote> getHotes() {
        return hotes;
    }

    public ArrayList<Logement> getLogements() {
        return logements;
    }

    public ArrayList<Voyageur> getVoyageurs() {
        return voyageurs;
    }
}
