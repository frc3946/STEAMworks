package org.usfirst.frc.team3946.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int fRightDriveTalon = 1;
	public static int fLeftDriveTalon = 2;
	public static int bRightDriveTalon = 3;
	public static int bLeftDriveTalon = 4;
	public static int winchTalon = 0;
	
	//Encoders.. what should they be int-ed to?
	public static int rightWheelEncoderA = 1;
	public static int rightWheelEncoderB = 1;
	public static int leftWheelEncoderA = 2; 
	public static int leftWheelEncoderB = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
