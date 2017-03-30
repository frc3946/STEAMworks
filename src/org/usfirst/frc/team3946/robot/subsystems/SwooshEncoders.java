package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SwooshEncoders extends Subsystem {
	double angle;
	final int PulsePerRevolution = 440;
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
    
    public void angleUp(int i) {
    	this.angle = getAngle();
    	//double tempAngle = this.angle;
   		//swooshTalon.set(1.0); 
    	while (this.angle < i) {  		
    			swooshTalon.set(1.0);
    			this.angle = getAngle();
    	}
    		swooshTalon.set(0);
    	
    		
    }	
    
    public void angleDown(int i) {
    	this.angle = getAngle();
    	//double tempAngle = this.angle;
    	if (this.angle >= i) {
    		swooshTalon.set(-.9); 
    	}
    	else {
    		swooshTalon.set(0);
    	}

    }	
    public void manualSet() {
    	swooshTalon.set(-.3);
    	Timer.delay(.9);
    	swooshTalon.set(0.0);
    	Robot.swooshencoders.swooshEncoder.reset();
    }

    public void checkForGear() {
    	boolean test1 = RobotMap.lightOne.get();
      	boolean test2 = RobotMap.lightTwo.get();
      	boolean test3 = RobotMap.lightThree.get();
      	this.angle = getAngle();
      	if (this.angle < -5 && (test1 == false || test2 == false || test3 == false)) {
       		angleUp(10);
      		//swooshTalon.set(.9);
        	//Timer.delay(.1);
        	//swooshTalon.set(0);
        	//Timer.delay(10);
    			}
     
    }
    public void timedUpForward() {
    	swooshTalon.set(1.0);
    	Timer.delay(.3);
    	swooshTalon.set(0);
    }
    public void timedUpBack() {
    	swooshTalon.set(-.9);
    	Timer.delay(.5);
    	swooshTalon.set(0);
    }
    public void manualGo() {
    	swooshTalon.set(.9);
    	Timer.delay(.1);
    	swooshTalon.set(0);
    }
}


