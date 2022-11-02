package projet_v2;

import lejos.hardware.motor.Motor;
import lejos.robotics.subsumption.Behavior;

public class Recul implements Behavior{

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		Motor.B.stop(true);
		Motor.C.stop(true); 
	}
	

}
