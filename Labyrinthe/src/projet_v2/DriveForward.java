package projet_v2;


import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class DriveForward implements Behavior, Parametres {
		private int coordonnéeI = COORDONNEE_ID;
		private int coordonnéeJ = COORDONNEE_JD;
		private float[] tabdir = new float [4]; //tableau des directions, ne change pas
		private int direction = 2; //le robot commence face vers le haut, donc 2
		//private boolean axeI; private boolean axeJ; inutile si on possède la direction
		private boolean tourne = false;
		
		public DriveForward () {
			for (int i=0; i<=3; i++) { // 0=bas 1=gauche 2=haut 3=droite
				tabdir[i]=i;
			}
		}
		
		public void setParameter(boolean tr) {
			this.tourne = tr;
		}
		/*
	         * Returns the parameter as set by setParameter()
	         */
			public boolean getParameter() {
				return this.tourne;
			}
		
		@Override
		public boolean takeControl() {return true; }
		
		@Override
		public void suppress() {
			Motor.B.stop(true);
			Motor.C.stop(true); 
		}
		
		@Override
		public void action () {
			LCD.clear();
			LCD.drawString("MoveForward", 0, 1);
			LCD.refresh();
			Wheel wheel1 = WheeledChassis.modelWheel(Motor.B,56.).offset(-60);
			Wheel wheel2 = WheeledChassis.modelWheel(Motor.C,56.).offset(60);
			
			Chassis chassis = new WheeledChassis(new Wheel[] {wheel1, wheel2},2); 
			MovePilot pilot = new MovePilot(chassis); 
			
			Button.RIGHT.waitForPressAndRelease();
			
			double distance = TAILLECASE*10 ; //conversion en mm 
			pilot.travel(distance);
			
			
			//manière de mettre à jour les coordonnées pour ne pas perdre le robot
			if (direction==2) { //si on est sur l'axe I et que la direction est haut, on fait donc +1
				coordonnéeI=coordonnéeI+1;
			}
			else if (direction==0){ //l'inverse, la direction est bas donc -1
				coordonnéeI=coordonnéeI-1;
			}
			
			if (direction == 3) { //l'axe J et que la direction est droite +1
				coordonnéeJ=coordonnéeJ+1;
			}
			else if (direction==1){ //l'inverse, la direction est fauche donc -1
				coordonnéeJ=coordonnéeJ-1;
			}
			
			//manière de changer de direction et de savoir dans quel direction est le robot
			if (coordonnéeAI == coordonnéeI) {
				tourne = true;
				if (direction <=2) {
					direction+=1;
				}
				else {direction=0;}
			}
			if (coordonnéeAJ == coordonnéeJ) { //tourne toujours dans le même sens donc toujours +1
				tourne = true;
				if (direction <=2) {
					direction+=1;
				}
				else {direction=0;}
			}
		}
		
		public void settourne (boolean tr){     // écriture
		     tourne = tr;
		}
		
		
	}
