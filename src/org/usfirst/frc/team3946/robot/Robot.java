
package org.usfirst.frc.team3946.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.Preferences;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

//import org.opencv.core.Mat;
//import org.opencv.core.Rect;
//import org.opencv.imgproc.Imgproc;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 
import org.usfirst.frc.team3946.robot.commands.TankDrive;
import org.usfirst.frc.team3946.robot.subsystems.ClimbMotor;

//import org.usfirst.frc.team3946.robot.subsystems.DriveTrainEncoder;
//import org.usfirst.frc.team3946.robot.subsystems.driveTrain;
import org.usfirst.frc.team3946.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3946.robot.subsystems.DriveTrainEncoder;
import org.usfirst.frc.team3946.robot.subsystems.LimitSwitch;
import org.usfirst.frc.team3946.robot.subsystems.SwooshEncoders;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain drivetrain = new DriveTrain();
	
	// preferences
	public static Preferences prefs;
	public static Accelerometer accel = new BuiltInAccelerometer();
	public static double distanceTarget = 130;
	public static double distanceOffset = 0;
	public static double angleMultiplier = 1;
	public static double angleAddition = 0;
	public static double distanceMultiplier = 1;
	public static double distanceAddition = 0;
	public static double leftInches = 0;
	public static double rightInches = 0;
	public static double leftTicks = 0;
	public static double rightTicks = 0;

	public static SendableChooser<String> controllerSelector;
	public static SendableChooser<String> cameraSelector;
	static String lastSelected = "";
	static int currSession=0;
	static int sessionfront=0;
	static int sessionback=0; 
	
//	private static final int IMG_WIDTH = 320;
//	private static final int IMG_HEIGHT = 240;
	
//	private VisionThread visionThread;
//	private double centerX = 0.0;
//	private RobotDrive drive;
//	
//	private final Object imgLock = new Object();


	public static DriveTrainEncoder driveTrainEncoder = new DriveTrainEncoder();
	public static ClimbMotor climbmotor = new ClimbMotor();
	public static LimitSwitch limitswitch = new LimitSwitch();
	public static SwooshEncoders swooshencoders = new SwooshEncoders();
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
//		CameraServer.getInstance().startAutomaticCapture(); 
		
		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(1);
		cam0.setFPS(30);
		cam0.setResolution(200, 200);
		cam1.setFPS(30);
		cam1.setResolution(200, 200);
		
		oi = new OI();

		// chooser.addObject("My Auto", new MyAutoCommand());
		
		cameraSelector = new SendableChooser<String>();
		cameraSelector.addDefault("Front View", "Front View");
		cameraSelector.addObject("Back View", "Back View");
				
		controllerSelector = new SendableChooser<String>();

		controllerSelector.addDefault("XboxController", "XboxController");
		controllerSelector.addObject("Joystick", "Joystick");
		SmartDashboard.putData("Controller Chooser", controllerSelector);

		controllerSelector.addDefault("Joystick", "Joystick");
		controllerSelector.addObject("XboxController", "XboxController");
			
//		distanceTarget = prefs.getDouble("DistanceTarget", distanceTarget);
//	 	distanceOffset = prefs.getDouble("DistanceOffset", distanceOffset);
	 	
	 	SmartDashboard.putData("Camera Selector", cameraSelector);
	 	SmartDashboard.putData("Controller Chooser", controllerSelector);
	 	SmartDashboard.putData("Auto mode", chooser);
	 	SmartDashboard.putNumber("Angle",
				(Math.atan2(Robot.accel.getY(), Robot.accel.getZ()))
						* (180 / Math.PI));
	
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	// instantiate the command used for the autonomous period autonomous Command = new RobotDrive();
		//autonomousCommand = new ();
	}

	public void autonmousInit() {
		// schedule the autonomous command () 
		if (autonomousCommand != null) autonomousCommand.start();
	}

/**
 * This function is called periodically during autonomous
 */
	public void autonomousPeriodic1() {
		Scheduler.getInstance().run();	}
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
	//	autonomousCommand = chooser.getSelected();
		if (Timer.getMatchTime() == 15) {	
	//	double driveTo = Robot.driveTrainEncoder.getRightDistance();
		
//		 (driveTo >= 90) {
	//		Robot.drivetrain.Drive(0.0, 0.0);
	//		Robot.driveTrainEncoder.stopEncoders();		
//			}
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		}}
	

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {

		Scheduler.getInstance().run();
		
	}

		
		
	


	@Override
	public void teleopInit() {
	
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
//	double angle = Robot.swooshencoders.getAngle();
//		while (angle <= 5) {
		Robot.swooshencoders.checkForGear();
//		angle = Robot.swooshencoders.getAngle();
//		}
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Actual Right Distance",
				Robot.driveTrainEncoder.getRightDistance());
		SmartDashboard.putNumber("Actual Left Distance",
				Robot.driveTrainEncoder.getLeftDistance());
	SmartDashboard.putNumber("Encoder Winch",
				Robot.swooshencoders.getAngle());
	SmartDashboard.putNumber("FingerTips", RobotMap.fingerTips.getValue());
	SmartDashboard.putBoolean("gear?",  RobotMap.lightOne.get());
	SmartDashboard.putBoolean("gear2?",  RobotMap.lightTwo.get());
	SmartDashboard.putBoolean("gear3?",  RobotMap.lightThree.get());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
 