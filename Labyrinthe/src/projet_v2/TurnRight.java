package projet_v2;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;


public class TurnRight implements Behavior {
	DriveForward drive = new DriveForward();
	private boolean tourne = drive.getParameter();
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return /*tourne*/Button.RIGHT.isDown();
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("TurnRight", 0, 1);
		System.out.println(tourne);
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
