package projet_v2;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Environnement environnement = new Environnement(); 
		environnement.initialisationEnvironnement();
		//boolean axeI=false;
		//boolean axeJ=false;
		//environnement.affichePlateau() ;
		Button.waitForAnyPress();
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
		EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S1);
		Behavior b = new LowBattery(cs,ts);
		//Behavior b1 = new DriveForward(); // Avancer
		//Behavior b2 = new TurnRight();
		EmergencyStop b3=new EmergencyStop (cs,ts);
		Behavior b4 = new CapterCouleur(cs);
		Behavior b5 = new Recul();
		Behavior[] bArray = { b5, b4, b3, b};
		Arbitrator arby = new Arbitrator(bArray);
		b3.setArby(arby);
		arby.go();
	}

}
