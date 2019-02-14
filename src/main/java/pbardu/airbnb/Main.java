package pbardu.airbnb;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import pbardu.airbnb.data.AirBnBData;
import pbardu.airbnb.data.Search;
import pbardu.airbnb.data.SearchInterface;

import pbardu.airbnb.logements.Logement;
import pbardu.airbnb.page.PagePrincipale;
import pbardu.airbnb.utilisateurs.Voyageur;
import pbardu.airbnb.reservations.*;

public class Main {

    public static void main(String[] args) {

        /*
        Search.SearchBuilder searchBuilder = new Search.SearchBuilder(2).possedeBalcon(false);
        Search search = searchBuilder.build();
        ArrayList<Logement> logements = search.result();

        for (Logement logement: logements) {
            System.out.println("--------------------------");
            logement.afficher();
        }

        */


        /*Voyageur voyageur = AirBnBData.getInstance().getVoyageurs().get(0);


        Voyageur voyageur = AirBnBData.getInstance().getVoyageurs().get(0);

        // Critères de mon séjour
        Date dateArrivee = new Date(1552255232322l);
        Logement logement = AirBnBData.getInstance().getLogements().get(1);
        int nbNuits = 2;
        int nbVoyageurs = 2;

        Sejour sejour = SejourFactory.getSejour(dateArrivee, logement, nbNuits, nbVoyageurs);
*/
        // Réservation
       // SearchInterface reservation = new SearchInterface();
    	
    	PagePrincipale laPagePrincipale = new PagePrincipale();
    	laPagePrincipale.pagePrincipale();

    }
}
