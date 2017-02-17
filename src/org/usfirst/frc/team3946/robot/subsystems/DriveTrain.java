package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.commands.TankDrive;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public RobotDrive robotDrive = new RobotDrive(RobotMap.fLeft, RobotMap.fRight);
	

	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
//		robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
//		robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		LiveWindow.addActuator("Drive Motors", "fRight", RobotMap.fRight);
		LiveWindow.addActuator("Drive Motors", "fLeft", RobotMap.fLeft);
		LiveWindow.addActuator("Drive Motors", "bRight", RobotMap.bRight);
		LiveWindow.addActuator("Drive Motors", "bLeft", RobotMap.bLeft);
	}

	public void Drive(double speedLeft, double speedRight) {
		RobotMap.fRight.set(speedRight);
		RobotMap.fLeft.set(speedLeft);
		RobotMap.bRight.set(speedRight);
		RobotMap.bLeft.set(speedLeft);
	}

	public void ReverseDrive() {
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
	}

	public void ForwardDrive() {
		robotDrive.setInvertedMotor(MotorType.kFrontLeft, false);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, false);
		robotDrive.setInvertedMotor(MotorType.kRearRight, false);
		robotDrive.setInvertedMotor(MotorType.kRearLeft, false);
	}
}
