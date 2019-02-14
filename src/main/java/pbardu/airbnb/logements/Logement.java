package pbardu.airbnb.logements;

import pbardu.airbnb.utilisateurs.Hote;

public abstract class Logement {

	private final Hote hote;
	private final int tarifParNuit;
	private final String adresse;
	private final int superficie;
	private final int nbVoyageursMax;

	public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {

		this.hote = hote;
		this.tarifParNuit = tarifParNuit;
		this.adresse = adresse;
		this.superficie = superficie;
		this.nbVoyageursMax = nbVoyageursMax;
	}

	public void afficher() {
		System.out.println(this.toString());
	}


	@Override
	public String toString() {
		return "Logement avec l'hote : " + hote +
				" le tarif par nuit est de : " + tarifParNuit +
				" situé à : " + adresse  +
				" d'une superficie de : " + superficie +" m2 "+
				" accueille un maximum de : " + nbVoyageursMax + " personne(s) " ;
	}

	public int getTarifParNuit() {
		return tarifParNuit;
	}

	public Hote getHote() {
		return hote;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getSuperficie() {
		return superficie;
	}

	public int getNbVoyageursMax() {
		return nbVoyageursMax;
	}
}
