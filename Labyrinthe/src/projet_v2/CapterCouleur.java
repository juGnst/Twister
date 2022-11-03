package projet_v2;


import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;

import lejos.robotics.subsumption.Behavior;

public class CapterCouleur implements Behavior{
	private EV3ColorSensor capteurCouleur ; 
	private float[] tabRGB = new float[3] ;
	private String couleur; 

	public CapterCouleur(EV3ColorSensor c) {
		this.capteurCouleur = c ;
	}

	@Override
	public boolean takeControl() {return true; }

	@Override
	public void suppress() {
		
	}

	@Override
	public void action () {
		capteurCouleur.getRGBMode().fetchSample(this.tabRGB, 0);
		LCD.clear();
		for (int i = 0; i<= 2; i++) {
			float color = tabRGB[i]*1000; //à garder tant qu'on test mais on pourra peut être enlever dans la version finale
			System.out.println((int)color);
			tabRGB[i] = tabRGB[i]*1000;
		}
		int total = (int)(tabRGB[0]+tabRGB[1]+tabRGB[2]);
		//pour palier au problème de luminosité, essayer de controler la couleur par rapport à sa proportion
		//if(tabRGB[0]<=(int)tabRGB[2]-20 && tabRGB[1]>=60 && tabRGB[2]>=60) {
		float condition_r=((tabRGB[0])/total)*100;
		float condition_b=((tabRGB[2])/total)*100;
		float  condition_v=((tabRGB[1])/total)*100;
		float  condition_o1=(((tabRGB[0])/total)*100);
		float  condition_o2=(((tabRGB[1])/total)*100);
		if (condition_b > 40) {
			LCD.drawString("Bleu", 3, 4);
			LCD.refresh();
			this.couleur = "Bleu" ; 
			
		} //if (tabRGB[0]>=60 && tabRGB[1]<=(int)tabRGB[0]-20 && tabRGB[2]<=(int)tabRGB[0]-20) {
			if (condition_r > 40) {
			LCD.drawString("Rouge", 3, 4);
			LCD.refresh();
			this.couleur = "Rouge";
			
		} //if (tabRGB[0]>=200 && (tabRGB[1]>=80 && tabRGB[1]<=230)&& tabRGB[2]<=200) {
		    if (condition_o1 > 40 && condition_o2 > 25) {
			LCD.drawString("Orange", 3, 4);
			LCD.refresh();
			this.couleur = "Orange";
		
		} if (condition_v > 50) { 
			LCD.drawString("Vert", 3, 4);
			LCD.refresh();
			this.couleur = "Vert" ; 
			
		} if (tabRGB[0]>=100 && tabRGB[1]>=100 && tabRGB[2]>=100) {
			LCD.drawString("Blanc", 3, 4);
			LCD.refresh();
			this.couleur = "Blanc";
			
			
		} /*else {
			LCD.drawString("Erreur", 3, 4);
			LCD.refresh();
			Sound.beep();
		}*/
		capteurCouleur.close();
		Button.waitForAnyPress();
	}


}

