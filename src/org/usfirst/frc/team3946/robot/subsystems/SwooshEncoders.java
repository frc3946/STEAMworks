package org.usfirst.frc.team3946.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SwooshEncoders extends Subsystem {
	int PulsePerRevolution = 440;
	Talon swooshTalon = new Talon(1);
	Encoder swooshEncoder = new Encoder(6, 7);//, Encoder.EncodingType.k4X);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 
    public void initDefaultCommand() {
  	swooshEncoder.setDistancePerPulse(7);
    	//convert to degrees
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void angle0() {
    	double distance = swooshEncoder.getDistance();
    	double angle = distance*PulsePerRevolution/360;
    	if (angle > 0) {
    		swooshTalon.set(-.1); 
    	}
    	else {
    		swooshTalon.set(0);
    	}
    }	
    public void angle45() {
    	double distance = swooshEncoder.getDistance();
    	double angle = distance*PulsePerRevolution/360;
    	if (angle > 45) {
    		swooshTalon.set(-.1); 
    	}
    	else if (angle < 45) {
    		swooshTalon.set(.1);
    	}
    	else {
    		swooshTalon.set(0);
    	}
    }
    public void angle90() {
    	double distance = swooshEncoder.getDistance();
    	double angle = distance*PulsePerRevolution/360;
    	if (angle > 90) {
    		swooshTalon.set(-.1); 
    	}
    	else if (angle < 90) {
    		swooshTalon.set(.1);
    	}
    	else {
    		swooshTalon.set(0);
    	}
    }
    public void angle180() {
    	double distance = swooshEncoder.getDistance();
    	double angle = distance*PulsePerRevolution/360;
    	if (angle > 180) {
    		swooshTalon.set(-.1); 
    	}
    	else if (angle < 180) {
    		swooshTalon.set(.1);
    	}
    	else {
    		swooshTalon.set(0);
    	}
    }
}

