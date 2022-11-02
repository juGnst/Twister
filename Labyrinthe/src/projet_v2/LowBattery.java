package projet_v2;

import lejos.hardware.BrickFinder;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class LowBattery implements Behavior {
	private EV3ColorSensor capterCouleur;
	private EV3TouchSensor touch;
	private Arbitrator arby;
	
	public LowBattery(EV3ColorSensor cs, EV3TouchSensor ts) {
		this.capterCouleur = cs; this.touch=ts;
	}
	
	public void setArby (Arbitrator a) {
		this.arby=a;
	}

	@Override
	public boolean takeControl() {return BrickFinder.getDefault().getPower().getVoltageMilliVolt() <=3000;}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("La batterie est faible");
		capterCouleur.close();
		touch.close();
		arby.stop();
		Motor.B.stop(true); Motor.C.stop(true);
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	

}
