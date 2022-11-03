package projet_v2;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class TurnRight implements Behavior {
	private boolean tourne;
	
	
	public boolean gettourne(){ // lecture
	     return tourne;
	}
	
	public TurnRight(boolean tr)
	{
		this.tourne = tr;
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return /*tourne*/Button.RIGHT.isDown();
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("TurnRight", 0, 1);
		LCD.refresh();
		
		Motor.B.forward();
		Delay.msDelay(100); //essais à faire pour avoir la bonne distance ?
		Motor.B.stop();		
	}

	@Override
	public void suppress() {
		Motor.B.stop(true);
		tourne=false;
	}
}
