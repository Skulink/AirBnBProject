package pbardu.airbnb.reservations;

import java.util.Date;

import pbardu.airbnb.utilisateurs.Voyageur;

public class Reservation implements Cloneable {

	private int id;
	private Sejour sejour;
	private Voyageur voyageur;
	private Date dateDeReservation;
	private boolean estValidee;

	public Reservation(Sejour sejour, Voyageur voyageur) {


		if (sejour == null || voyageur == null) {
			throw new IllegalArgumentException("Impossible de créer une réservation");
		}

		if (!sejour.verficationNombreDeNuits()) {
			throw new IllegalArgumentException("Nombre de nuits incorrect");
		}

		if (!sejour.verficationDateArrivee()) {
			throw new IllegalArgumentException("Date d'arrivée incorrecte");
		}

		if (!sejour.verficationNombreDeVoyageurs()) {
			throw new IllegalArgumentException("Nombre de voyageurs incorrect");
		}

		this.id = 0;
		this.sejour = sejour;
		this.voyageur = voyageur;

		dateDeReservation = new Date();
		estValidee = false;
	}

	public void afficher() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return voyageur.toString() + " a fait une réservation chez " + sejour.toString() + "La réservation " + ((estValidee) ? "est" : "n'est pas" )+ " validée";
	}

	public void setEstValidee(boolean estValidee) {
		this.estValidee = estValidee;
	}

	public Sejour getSejour() {
		return sejour;
	}

	@Override
	public Object clone()  {

		Reservation reservation = null;

		try {
			reservation = (Reservation) super.clone();
			// Date
			reservation.dateDeReservation = (Date) dateDeReservation.clone();
			// Sejour
			reservation.sejour = (Sejour) sejour.clone();

		} catch (CloneNotSupportedException e) {
		}

		return reservation;
	}
}
