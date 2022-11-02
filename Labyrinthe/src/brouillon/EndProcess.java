package brouillon;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class EndProcess implements Behavior {
	//private EV3UltrasonicSensor ultrasonic;
	private EV3ColorSensor color;

	private Arbitrator arby;
	
	public EndProcess(EV3ColorSensor cs){
		//this.ultrasonic = us;
		this.color = cs;

	}
	public void setArbitrator(Arbitrator ar){
		this.arby = ar;
	}
	public boolean takeControl() { 
		return Button.RIGHT.isDown();
		}
	
	public void suppress() {
		
	}
	
	public void action() {
		LCD.clear();
		LCD.drawString("EndProcess", 0, 1);
		LCD.refresh();
		Motor.B.stop(true);
		Motor.C.stop(true);
		//ultrasonic.close();
		color.close();
		//gyro.close();
		arby.stop();
	}
}
