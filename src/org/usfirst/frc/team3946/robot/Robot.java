
package org.usfirst.frc.team3946.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3946.robot.commands.Drive;
import org.usfirst.frc.team3946.robot.commands.GearDelivery;
import org.usfirst.frc.team3946.robot.subsystems.ClimbMotor;
import org.usfirst.frc.team3946.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3946.robot.subsystems.DriveTrainEncoder;

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
	public static SendableChooser<String> controllerSelector;
	public static SendableChooser<String> cameraSelector;
	
	//autonomous code?
	Command autonomousCommand;

	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
//		autonomousCommand = new GearDelivery();
		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(1);
	
		SmartDashboard.putData("Auto mode", chooser);
		
		cameraSelector = new SendableChooser<String>();
		cameraSelector.addDefault("Front View", "Front View");
		cameraSelector.addObject("Back View", "Back View");
		SmartDashboard.putData("Camera Selector", cameraSelector);		
		
		controllerSelector = new SendableChooser<String>();
		controllerSelector.addDefault("XboxController", "XboxController");
		controllerSelector.addObject("Joystick", "Joystick");
		SmartDashboard.putData("Controller Chooser", controllerSelector);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		// instantiate the command used for the autonomous period autonomous Command = new RobotDrive();

	}


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

	public void autonomousInit() {
//		autonomousCommand = chooser.getSelected();
		Robot.drivetrain.Drive(-0.7, -0.7);
		Timer.delay(1.0);
		if (autonomousCommand != null) 
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	
	public void AutonomousPeriodic() {
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
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Actual Right Distance",
				Robot.driveTrainEncoder.getRightDistance());
		SmartDashboard.putNumber("Actual Left Distance",
				Robot.driveTrainEncoder.getLeftDistance());

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
