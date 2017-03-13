package org.usfirst.frc.team3946.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static CANTalon fRight = new CANTalon(1);
	public static CANTalon fLeft = new CANTalon(2);
	public static CANTalon bRight = new CANTalon(3);//works right
	public static CANTalon bLeft = new CANTalon(4); //works, left
	public static int winchTalon = 0;
	public static int swooshTalon = 1;
	public static AnalogInput fingerTips = new AnalogInput(1);
	public static DigitalInput lightOne = new DigitalInput(3);
	public static DigitalInput lightTwo = new DigitalInput(4);
	public static DigitalInput lightThree = new DigitalInput(5);
	 
//	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
