package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion=1;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMax);
		while (forcePotion<effetPotionMin) {
			forcePotion = random.nextInt(effetPotionMax);
		}
		if (forcePotion>7) {
			System.out.println(prendreParole() + "« J'ai préparé une super potion de force " + forcePotion + "»");
		} else {
		System.out.println(prendreParole() + "« Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion + "»");
		}
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() != "Obélix") {
		gaulois.boirePotion(forcePotion);
		}
		else {
			System.out.println(prendreParole() + "« Non, Obélix !... Tu n’auras pas de potion magique ! »");
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide ("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}
	
	
}