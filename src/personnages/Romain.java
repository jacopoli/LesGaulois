package personnages;


public class Romain {
	private String nom;
	private int force;
	private Equipement equipements[];
	private int nbEquipements=0;
	
	public Romain(String nom, int force) {
		assert force>=0 : "La force doit �tre positive.";
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
		
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
		case 2:
			System.out.println("Le soldat " + nom + " est d�j� bien prot�g� !");
			break;
		case 0: 
			equipements[nbEquipements]=equipement;
			nbEquipements++;
			System.out.println("Le soldat " + nom + "s'�quipe avec un " + equipement.toString() + ".");
			break;
		case 1:
			if (equipement.toString()!= equipements[0].toString()) {
				equipements[nbEquipements]=equipement;
				nbEquipements++;
			} else {
				System.out.println("Le soldat " + nom + " poss�de d�j� un " + equipement.toString() + "!");
			}
			break;
		default:
	        System.out.println("Erreur nombre d'�quipements");
	        break;
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force>=0: "La force du romain n'est pas positive.";
		int forceAvantCoup=force;
		force -= forceCoup;
		assert forceAvantCoup>force: "La force du romain n'a pas diminu�.";
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		Romain manus = new Romain("Manus", -6);
		manus.parler("Bonjour!");
		manus.recevoirCoup(6);
	}
}


