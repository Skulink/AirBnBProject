package pbardu.airbnb.utilisateurs;

public final class Hote extends Personne {

	private final int delaiReponse;

	public Hote(String nom, String prenom, int age, int delaiReponse) {
		super(nom, prenom, age);
		this.delaiReponse = delaiReponse;
	}

	@Override
	public void afficher() {
		System.out.println(this.toString());
	}

	public int getDelaiReponse() {
		return delaiReponse;
	}

	@Override
	public String toString() {
		return super.toString() + " qui s'engage à répondre dans les " + delaiReponse + " heures";
	}
}
