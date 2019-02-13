package pbardu.airbnb;

import java.util.ArrayList;
import java.util.Date;

import pbardu.airbnb.data.AirBnBData;
import pbardu.airbnb.data.Search;
import pbardu.airbnb.logements.Logement;
import pbardu.airbnb.utilisateurs.Voyageur;
import pbardu.airbnb.reservations.*;
import pbardu.airbnb.web.Accueil;

public class Main {

    public static void main(String[] args) {
//Appel interface graphique accueil
        Accueil mainpage = new Accueil();
        mainpage.show();


        /*
        Search.SearchBuilder searchBuilder = new Search.SearchBuilder(2).possedeBalcon(false);
        Search search = searchBuilder.build();
        ArrayList<Logement> logements = search.result();

        for (Logement logement: logements) {
            System.out.println("--------------------------");
            logement.afficher();
        }

        */

/*
        Voyageur voyageur = AirBnBData.getInstance().getVoyageurs().get(0);

        // Critères de mon séjour
        Date dateArrivee = new Date(1552255232322l);
        Logement logement = AirBnBData.getInstance().getLogements().get(1);
        int nbNuits = 2;
        int nbVoyageurs = 2;

        Sejour sejour = SejourFactory.getSejour(dateArrivee, logement, nbNuits, nbVoyageurs);

        // Réservation
        Reservation reservation = new Reservation(sejour, voyageur);
        reservation.afficher();



*/

    }
}
