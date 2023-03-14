package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion=1;
	private Equipement[] trophees = new Equipement[100];



	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte +"»");
	}

//	private String prendreParole() {
//		// TODO Auto-generated method stub
//		return "Le gaulois " + nom+ " : ";
//	}

	//	public void frapper(Romain romain) {
	//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
	//		romain.recevoirCoup(force/3);
	//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}
	}


	public void boirePotion( int forcePotion) {
		effetPotion=forcePotion;
		System.out.println(prendreParole() + "« Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée. »");
		force=force*effetPotion/3;
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}


	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		asterix.parler("Bonjour!");
		Romain manus = new Romain("Manus", 1);
		asterix.frapper(manus);
		asterix.boirePotion(12);

	}
}


