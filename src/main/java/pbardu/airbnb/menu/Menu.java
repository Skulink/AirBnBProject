package pbardu.airbnb.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import pbardu.airbnb.logements.Appartement;
import pbardu.airbnb.logements.Logement;
import pbardu.airbnb.logements.Maison;
import pbardu.airbnb.reservations.Reservation;
import pbardu.airbnb.utilisateurs.Hote;
import pbardu.airbnb.utilisateurs.Voyageur;

public class Menu {

	static Scanner scanner;

	static ArrayList<Hote> listHotes;


	public static ArrayList<Logement> listLogements;
	static ArrayList<Voyageur> listVoyageurs;
	static ArrayList<Reservation> listReservations;

	public static void main(String[] args) {

		System.out.println("Bienvenu chez AirBnB");

		scanner = new Scanner(System.in);

		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		listVoyageurs = new ArrayList<>();
		listReservations = new ArrayList<>();

		init();

		listerMenu();

		scanner.close();
	}

	public static ArrayList<Logement> getListLogements() {
		return listLogements;
	}
	static void listerMenu() {

		System.out.println("-------------------------------------");
		System.out.println("Saisir une option : ");
		System.out.println("1 : Liste des hôtes");
		System.out.println("2 : Liste des logements");
		System.out.println("3 : Liste des voyageurs");
		System.out.println("4 : Liste des réservations");
		System.out.println("5 : Fermer le programme");

		switch (choix(5)) {
		case 1:
			GestionHotes.listerHotes();
			break;
		case 2:
			GestionLogements.listerLogements();
			break;
		case 3:
			GestionVoyageurs.listerVoyageurs();
			break;
		case 4:
			GestionReservations.listerReservations();
			break;
		case 5:
			System.out.println("A bientôt");
			break;
		}

	}

	private static void init() {

		// Cr�ation des Hotes
		Hote hote1 = new Hote("Peter", "Bardu", 28, 12);
		Hote hote2 = new Hote("Patrick", "Martin", 32, 12);
		Hote hote3 = new Hote("Jeanne", "Voisin", 26, 24);
		Hote hote4 = new Hote("Maurice", "Meunier", 46, 12);

		listHotes.add(hote1);
		listHotes.add(hote2);
		listHotes.add(hote3);
		listHotes.add(hote4);

		// Cr�ation de Logement
		Maison maison1 = new Maison(hote1, 40,
				"18 Bis rue Romain Rolland, 37230 Fondettes", 140, 2, 500, true);
		Maison maison2 = new Maison(hote1, 35,
				"146 Rue George Sand, 59553 Cuincy", 120, 2, 200, false);
		Maison maison3 = new Maison(hote1, 60,
				"13 Rue de la Libert�, 62800 Li�vin", 90, 4, 2000, true);
		Appartement appartement1 = new Appartement(hote1, 35,
				"46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20);
		Appartement appartement2 = new Appartement(hote1, 35,
				"111 Rue Colbert, 37000 Tours", 42, 2, 2, 0);

		listLogements.add(maison1);
		listLogements.add(maison2);
		listLogements.add(maison3);
		listLogements.add(appartement1);
		listLogements.add(appartement2);

		// Cr�ation de voyageurs
		Voyageur voyageur1 = new Voyageur("Alain", "Favre", 54);
		Voyageur voyageur2 = new Voyageur("Maxime", "Albert", 29);

		listVoyageurs.add(voyageur1);
		listVoyageurs.add(voyageur2);

	}

	static int choix(int maxValue) {

		int choix = 0;
		boolean choixOk = false;

		do {
			try {
				choix = scanner.nextInt();
				if (choix > 0 && choix <= maxValue)
					choixOk = true;
				else {
					System.out.println("Saisir une valeur entre 1 et "
							+ maxValue);
				}
			} catch (InputMismatchException e) {
				System.out.println("Saisir une valeur entre 1 et " + maxValue);
				scanner.next();
			}

		} while (!choixOk);

		return choix;
	}
}
