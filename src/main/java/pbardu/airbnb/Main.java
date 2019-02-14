package pbardu.airbnb;

import pbardu.airbnb.web.Accueil;

public class Main {

    public static void main(String[] args) {
        //Appel interface graphique accueil
        Accueil mainpage = new Accueil();
        mainpage.show();
    }
}
