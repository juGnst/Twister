package projet_v2;

import java.util.Arrays;

public class Environnement implements Parametres {

	private Case[][] plateau = new Case[I][J]; //Represente le plateau de jeu 

	/*
	 * Constructeur
	 */
	public Environnement() {

	}
	/*
	 *Permet d'afficher notre plateau de jeu de manière textuelle 
	 */
	public void affichePlateau(){
		System.out.println("\n");
		for (int i=0; i<I;i++){
			for (int j=0; j<Parametres.J;j++){
				System.out.print(plateau[i][j]+" ");
			}
			System.out.println("\n");
		}
	}

	/*
	 *Donne un accès en écriture pour modifier le contenu d'une case du plateau 
	 *@param int a correspond à  l'abscisse de la case
	 *@param int b correspond à  l'abscisse de la case
	 *@param Couleur c correspond à  la couleur associée à  une case
	 */

	/*public void setCase(int a, int b, String couleur){
		Case c = new Case(a,b,couleur) ; 
	
	}*/
	
	public void setCase(int a, int b, String color){
        this.plateau[a][b]= new Case (a, b, color) ;
    }


	public void initialisationEnvironnement() {
		//initialisation couleur bleue
		for (int i=0; i<=6; i++) {
			for (int j=0; j<=4; j++) {
				setCase(i,j,"Bleu");
			}
		}
		/*setCase(0,0,"Bleu");
		setCase(0,1,"Bleu");
		setCase(0,2,"Bleu");
		setCase(0,3,"Bleu");
		setCase(0,4,"Bleu");
		setCase(1,0,"Bleu");
		setCase(2,0,"Bleu");
		setCase(3,0,"Bleu");
		setCase(4,0,"Bleu");
		setCase(5,0,"Bleu");
		setCase(2,2,"Bleu");
		setCase(2,4,"Bleu");
		setCase(3,4,"Bleu");
		setCase(4,4,"Bleu");
		setCase(5,4,"Bleu");
		setCase(6,4,"Bleu");
		setCase(6,3,"Bleu");
		setCase(6,2,"Bleu");*/

		//initialisation couleur rouge 
		setCase(6,0,"Rouge");
		setCase(1,4,"Rouge");

		//initialisation couleur verte 
		setCase(1,2,"Vert");
		setCase(1,3,"Vert");
		setCase(2,3,"Vert");
		setCase(3,3,"Vert");
		setCase(3,1,"Vert");
		setCase(4,1,"Vert");
		setCase(5,1,"Vert");
		setCase(6,1,"Vert");
		setCase(5,2,"Vert");
		setCase(5,3,"Vert");

		//initialisation couleur blanche
		setCase(3,2,"Blanc");

		//initialisation couleur orange
		setCase(1,1,"Orange");
		setCase(2,1,"Orange");
		setCase(4,2,"Orange");
		setCase(4,3,"Orange");
	}
}
