package brouillon;

import lejos.robotics.subsumption.Behavior;
import projet_v2.Case;
import projet_v2.Environnement;
import projet_v2.Parametres;

public class TrouverChemin implements Behavior{
	private boolean tourne;
	private Environnement carte;
	
	public TrouverChemin(boolean tr, Environnement env) {
		this.tourne=tr;
		this.carte=env;
	}
	
	public class Verification implements Parametres { //v�rifier si la case est de la bonne couleur par rapport � la carte
		private Case[][] coordonnee = COORDONNEE_D;
		
		public void donnee() {
			
		}
		
		
	}

	@Override
	public boolean takeControl() {return true;}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	

}
