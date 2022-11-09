package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

	private final String immatriculation;
	private List<Stationnement> myStationnements = new LinkedList<>();

	public Voiture(String i) {
		if (null == i) {
			throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
		}

		immatriculation = i;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Fait rentrer la voiture au garage
	 * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws java.lang.Exception Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws Exception {
		// Et si la voiture est déjà dans un garage ?

		if(!this.estDansUnGarage()) {
			Stationnement s = new Stationnement(this, g);
			myStationnements.add(s);}
		else {
			throw new Exception("Est déjà dans un garage");
		}


	}

	/**
	 * Fait sortir la voiture du garage
	 * Précondition : la voiture doit être dans un garage
	 *
	 * @throws java.lang.Exception si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws Exception {

		// TODO: Implémenter cette méthode
		if(myStationnements.size()==0){
			throw new Exception("Liste de garage vide");}

		else{
			Stationnement stationnement = myStationnements.get(myStationnements.size()-1);

			if (stationnement.estEnCours()){
				stationnement.terminer();
			}
			else{
				throw new Exception("Le stationnement est déjà fini ");
			}

			}
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
	}

	/**
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
		Set<Garage> garages = new HashSet<>();

		for (Stationnement stationnement : myStationnements) {

			if (!garages.contains(stationnement.getGarage())) {
				garages.add(stationnement.getGarage());}

		}

		return garages;
	}

	/**
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		if(myStationnements.size()==0){
			return false;}

		else{
			Stationnement stationnement = myStationnements.get(myStationnements.size()-1);
			return stationnement.estEnCours();}


		// Vrai si le dernier stationnement est en cours
	}

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des
	 * dates d'entrée / sortie dans ce garage
	 * <br>
	 * Exemple :
	 * 
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out)
	 */
	public void imprimeStationnements(PrintStream out) {



		for (Garage garageVisite : this.garagesVisites()){

			out.println(garageVisite);
			for (Stationnement stationnement : myStationnements) {
				if (stationnement.getGarage().equals(garageVisite)) {
					 out.println(stationnement);
					}

			}
		}




		// TODO: Implémenter cette méthode

	}

}
