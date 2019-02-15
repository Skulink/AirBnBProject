package pbardu.airbnb.utilisateurs;


public class Personne {

	// 1° - Les attributs
	private final String nom;
	private final String prenom;
	private final int age;

	// 2° - le constructeur

	/**
	 *
	 * @param pNom
	 * @param pPrenom
	 * @param pAge
	 */

	public Personne(String pNom, String pPrenom, int pAge) {
		nom = pNom;
		prenom = pPrenom;
		age = pAge;
	}

	// 3° - la methode
	public void afficher() {
		System.out.print(this.toString());
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return prenom + " " + nom + " (" + age + " ans)";
	}
}
