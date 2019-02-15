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
		return  "<html>"+
				" Logement avec l'hote : " + hote + "<br/>" +
				" le tarif par nuit est de : " + tarifParNuit + "<br/>" +
				" situé à : " + adresse  + "<br/>" +
				" d'une superficie de : " + superficie +" m2 "+ "<br/>" +
				" accueille un maximum de : " + nbVoyageursMax + " personne(s)<br/>" +
				"----------------------------------------------------------------------------------------------" +
				"</html>";
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
