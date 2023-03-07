package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois=0;
	private int nbMaxVillageois;
	private Gaulois villageois[];
	
	public Village(String nom, int nbMaxVillageois) {
		this.nom = nom;
		this.nbMaxVillageois = nbMaxVillageois;
		villageois = new Gaulois[nbMaxVillageois];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public Chef getChef() {
		return chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois]=gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero-1];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans village du chef " + getChef().getNom() + " vivent les légendaires gaulois :");
		for (int i = 1; i <= nbVillageois; i++) {
			System.out.println("-" + trouverHabitant(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		/*Gaulois gaulois = village.trouverHabitant(30);
		 * exception car la case est vide
		 */
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		/*Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois);
		ça nous retour l'id de asterix
		*/
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
	}
}
