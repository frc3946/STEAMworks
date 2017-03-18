
package org.usfirst.frc.team3946.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

import org.usfirst.frc.team3946.robot.commands.AutoTravel;
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
		oi = new OI();
	// instantiate the command used for the autonomous period autonomous Command = new RobotDrive();
		autonomousCommand = new AutoTravel();
	}

	public void autonmousInit() {
		// schedule the autonomous command () 
		if (autonomousCommand != null) autonomousCommand.start();
	}

/**
 * This function is called periodically during autonomous
 */
	public void autonomousPeriodic1() {
		SmartDashboard.putNumber("Actual Left Distance",
				Robot.driveTrainEncoder.getLeftDistance());
		double distance = Robot.driveTrainEncoder.getLeftDistance();
		while (distance <= 150) {
    		Robot.drivetrain.Drive(-.3, -.3);
    		distance = Robot.driveTrainEncoder.getLeftDistance();
    		
    	}
    	Robot.drivetrain.Drive(0, 0);
    
		
		//SmartDashboard.putNumber("Actual Left Distance",
			//	Robot.driveTrainEncoder.getLeftDistance());
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
		
		
		}
	

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
