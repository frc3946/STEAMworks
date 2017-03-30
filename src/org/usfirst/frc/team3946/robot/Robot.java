
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
import org.usfirst.frc.team3946.robot.commands.GearDelivery;
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
	UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture();
	
	public static SendableChooser<String> autoPos;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		
		autoPos = new SendableChooser<>();
		autoPos.addDefault("Middle", "middle");
		autoPos.addObject("Left", "left");
		autoPos.addObject("Right", "right");
		SmartDashboard.putData("Middle", autoPos);
		
	// instantiate the command used for the autonomous period autonomous Command = new RobotDrive();
		autonomousCommand = new GearDelivery();
	}

	
	@Override
	public void autonomousInit() {
		RobotMap.bLeft.setPosition(0);
		RobotMap.bRight.setPosition(0);
		autonomousCommand = new GearDelivery();
		if (autonomousCommand != null) 
			autonomousCommand.start();
		
		}
	

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		Robot.climbmotor.stop();
		
	}

	@Override
	public void teleopInit() {
	
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		Robot.climbmotor.releaseMag();
		//Timer.delay(.01);
		Robot.climbmotor.stop();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Robot.swooshencoders.checkForGear();
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
	SmartDashboard.putBoolean("limit",  Robot.limitswitch.operatorControl());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
