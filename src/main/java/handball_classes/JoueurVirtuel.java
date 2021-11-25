package handball_classes;

import java.util.ArrayList;
import java.util.Objects;

import electronics_classes.Ordinateur;
import electronics_classes.Peripherique;
import exceptions.JoueurDejaMembreException;

public class JoueurVirtuel extends Joueur implements IJoueur {
	private Ordinateur ordinateur;
	
	// Constructeurs
	/**
	 * Constructeur d'objets de classe Joueur
	 * @param n : nom du joueur
	 * @param p : prénom du joueur
	 * @param num : numéro du joueur
	 * @param ordi : ordinateur du joueur
	 */
	public JoueurVirtuel(String nom, String prenom, int num, Ordinateur ordinateur){
		super(nom,prenom, num);
		this.ordinateur = ordinateur;
	}
	public JoueurVirtuel(String nom, String prenom, int num){
		super(nom, prenom, num);
	}
	public JoueurVirtuel(){}
	
	// Getters and setters
	public Ordinateur getOrdinateur() {
		return ordinateur;
	}
	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	// Méthodes
	/**
	 * Méthode affichant les informations du joueur : nom, prénom, son numéro et son ordinateur 
	 * Si le joueur est membre d'une équipe, le nom de l'équipe sera affiché avec les informations
	 * générales du joueur, sinon, le message affiché indiquera que le joueur n'a pas d'équipe
	 * @return les informations générales du joueur
	 */
	public String afficherDetailsJoueur(){
		String s = super.afficherDetailsJoueur();
		if(Objects.nonNull(this.ordinateur)) {
			s = s + ordinateur.sampleMethod();
		}
		return s ;
	}

	public void seDeconnecter() {
		this.getOrdinateur().setPeripheriques(new ArrayList<Peripherique>());
		this.setOrdinateur(null);
	}
	
	public void ajouterPeripherique(Peripherique...peripheriques) {
		for (Peripherique peripherique : peripheriques) { 
			if (this.getOrdinateur().getPeripheriques().contains(peripherique)) {
				// Throw an exception
				//throw new JoueurDejaMembreException();
				// Vérifier si le joueur ne fait pas partie d'une autre équipe
			} else {
				this.ordinateur.addPeripherique(peripherique);
			}
		}
	}
	
	@Override
	public void fonction() {
		System.out.println("Je suis un joueur virtuel de handball");
	}
}
