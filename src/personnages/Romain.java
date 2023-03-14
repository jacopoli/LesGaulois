package personnages;


public class Romain {
	private String nom;
	private int force;
	private Equipement equipements[];
	private int nbEquipements=0;
	//	private String texte;

	public Romain(String nom, int force) {
		assert force>=0 : "La force doit �tre positive.";
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];

	}

	public int getForce() {
		return force;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
		case 2:
			System.out.println("Le soldat " + nom + " est d�j� bien prot�g� !");
			break;
		case 0: 
			equipements[nbEquipements]=equipement;
			nbEquipements++;
			System.out.println("Le soldat " + nom + " s'�quipe avec un " + equipement.toString() + ".");
			break;
		case 1:
			if (equipement.toString()!= equipements[0].toString()) {
				System.out.println("Le soldat " + nom + " s'�quipe avec un " + equipement.toString() + ".");
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

	//	public void recevoirCoup(int forceCoup) {
	//		assert force>=0: "La force du romain n'est pas positive.";
	//		int forceAvantCoup=force;
	//		force -= forceCoup;
	//		assert forceAvantCoup>force: "La force du romain n'a pas diminu�.";
	//		if (force > 0) {
	//			parler("A�e");
	//		} else {
	//			parler("J'abandonne...");
	//		}
	//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		if (forceCoup<0) {
			forceCoup-=forceCoup;
		}
		force -= forceCoup;
		// if (force > 0) {
		// parler("A�e");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force==0) {
			parler("A�e");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminu�e
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipements; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'�quipement de " + nom+ " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
						equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}


	public static void main(String[] args) {
		Romain manus = new Romain("Manus", 10);
		manus.parler("Bonjour!");
		manus.recevoirCoup(6);
		manus.sEquiper(Equipement.CASQUE);
		manus.sEquiper(Equipement.CASQUE);
		manus.sEquiper(Equipement.BOUCLIER);
		manus.sEquiper(Equipement.BOUCLIER);
	}
}


