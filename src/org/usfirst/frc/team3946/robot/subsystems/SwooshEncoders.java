package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SwooshEncoders extends Subsystem {
	double angle;
	int PulsePerRevolution = 440;
	Talon swooshTalon = new Talon(1);
	public Encoder swooshEncoder = new Encoder(6, 7);//, Encoder.EncodingType.k4X);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 
    public void initDefaultCommand() {
  	swooshEncoder.setDistancePerPulse(7);
    	//convert to degrees
        // Set the default command for a subsystem here.
  	
    }
    public double getAngle() {
    	double distance = swooshEncoder.getDistance();
    	//360 as in degrees. the other factor is the manually calculated one by physically turning the encoder to a 90 degree
    	//position, finding out how many ticks that would be. (technically the 360 does not need to be there, but it is
    	//and already in the calculations for the scale factor)
    	double rawTicks = distance*PulsePerRevolution/360;
    	double angle = rawTicks*-.1155;
    	return angle;
  	}
    public void angle0() {
    	angle = getAngle();
    	if (angle > 0) {
    		swooshTalon.set(-.5);
    	
    	}
    	else {
    		swooshTalon.set(0);
    	}
    }	
    public void angle45() {
    	angle = getAngle();
    	if (angle > 45) {
    		swooshTalon.set(-.4); 
    		angle = getAngle();
    		if (angle == 45) {
    			swooshTalon.set(0);
    		}
    	}
    	else if (angle < 45) {
    		swooshTalon.set(.4);
    		angle = getAngle();
    		if (angle == 45) {
    			swooshTalon.set(0);
    		}
    	}
    	else {
    		swooshTalon.set(0);
    	}
    }
    public void angle90() {
    	angle = getAngle();
    	if (angle > 90) {
    		swooshTalon.set(-1.0); 
    	}
    	else if (angle < 90) {
    		swooshTalon.set(1.0);
    	}
    	else {
    		swooshTalon.set(0);
    	}
    }
    public void angle180() {
    	angle = getAngle();
    	//while (angle > 180) {
    		//swooshTalon.set(-1.0); 
    //	}
    	while (angle < 180) {
    		swooshTalon.set(0.5);
    		if (angle >= 180) {
    			swooshTalon.set(0);
    		}
    	}
    	//else {
    	
    //	}
    }
    public void checkForGear() {
    	boolean test1 = RobotMap.lightOne.get();
      	boolean test2 = RobotMap.lightTwo.get();
      	boolean test3 = RobotMap.lightThree.get();
       	//if (test1 == true || test2 == true || test3 == true) {
    			//Robot.swooshencoders.angle90();
       	//}
    	
    }
}


