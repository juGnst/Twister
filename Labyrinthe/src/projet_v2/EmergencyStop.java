package projet_v2;

import lejos.hardware.Button;	
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class EmergencyStop implements Behavior {
	private EV3ColorSensor capterCouleur;
	private EV3TouchSensor touch;
	private Arbitrator arby ; 
	
	public EmergencyStop(EV3ColorSensor cs, EV3TouchSensor ts){
		//this.ultrasonic = us;
		this.capterCouleur = cs;
		this.touch = ts;
	}
	
	public boolean takeControl() {
		return Button.LEFT.isDown(); 
	}

	public void setArby (Arbitrator a) {
		this.arby = a ; 
	}


	public void action() {
		// TODO Auto-generated method stub
		Motor.B.stop(true);
		Motor.C.stop(true);
		capterCouleur.close();
		touch.close();
		arby.stop();
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}