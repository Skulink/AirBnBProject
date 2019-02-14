package pbardu.airbnb.reservations;

import java.util.Date;

import pbardu.airbnb.logements.Logement;


/**
 *
 */
public abstract class Sejour implements SejourInterface, Cloneable {

	private Logement logement;
	private Date dateArrivee;
	private int nbNuits;
	private int nbVoyageurs;

	/**
	 *
	 * @param dateArrivee
	 * @param logement
	 * @param nbNuits
	 * @param nbVoyageurs
	 */
	public Sejour(Date dateArrivee, Logement logement, int nbNuits, int nbVoyageurs) {

		this.logement = logement;
		this.dateArrivee = dateArrivee;
		this.nbNuits = nbNuits;
		this.nbVoyageurs = nbVoyageurs;
	}

	public abstract void afficher();
	
	public abstract void miseAJourTarif();

	public void afficherSejour() {
		logement.afficher();
		System.out.println("La​ ​date​ ​d'arrivée​ ​est​ ​le​ ​" + dateArrivee + " ​pour​ ​" + nbNuits + "​ ​nuits.");
	}

	public Logement getLogement() {
		return logement;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public int getNbNuits() {
		return nbNuits;
	}

	public int getNbVoyageurs() {
		return nbVoyageurs;
	}

	/**
	 *
	 * @return true si dateArrivee.after(dateCourante)
	 */
	@Override
	public boolean verficationDateArrivee() {
		Date dateCourante = new Date();
		return dateArrivee.after(dateCourante);
	}

	/**
	 *
	 * @return true si nbVoyageurs > 0 && nbVoyageurs <= logement.getNbVoyageursMax()
	 */
	@Override
	public boolean verficationNombreDeVoyageurs() {
		return nbVoyageurs > 0 && nbVoyageurs <= logement.getNbVoyageursMax();
	}

	/**
	 *
	 * @param logement
	 */
	public void setLogement(Logement logement) {
		this.logement = logement;
		miseAJourTarif();
	}

	/**
	 *
	 * @param dateArrivee
	 */
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = (Date) dateArrivee.clone();
	}

	/**
	 *
	 * @param nbNuits
	 */
	public void setNbNuits(int nbNuits) {
		this.nbNuits = nbNuits;
		miseAJourTarif();
	}

	/**
	 *
	 * @param nbVoyageurs
	 */
	public void setNbVoyageurs(int nbVoyageurs) {
		this.nbVoyageurs = nbVoyageurs;
	}

	/**
	 *
	 * @return sejour
	 */
	@Override
	public Object clone()  {

		Sejour sejour = null;
		try {
			sejour = (Sejour) super.clone();
			sejour.dateArrivee = (Date) dateArrivee.clone();
		} catch (CloneNotSupportedException e) {
		}

		return sejour;
	}
}
