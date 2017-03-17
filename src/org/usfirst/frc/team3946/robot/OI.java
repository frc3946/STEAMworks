package org.usfirst.frc.team3946.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3946.robot.commands.RobotClimb;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

import libraries.XboxController;

import org.usfirst.frc.team3946.robot.commands.WinchStop;
import org.usfirst.frc.team3946.robot.commands.GearExtend;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick driveController1 = new Joystick(0);
	public Joystick driveController2 = new Joystick(1);
	Button winchButtonUp = new JoystickButton(driveController2, 1);
	Button winchButtonDown = new JoystickButton(driveController1, 1);
	Button gearPusher = new JoystickButton(driveController2, 3);
	Button sendToZero = new JoystickButton(driveController2, 4);
	
	
	public XboxController leftController = new XboxController(2);
//	Button 
	
	
	

public OI() {
	winchButtonUp.whenPressed(new RobotClimb());
	winchButtonDown.whenPressed(new WinchStop());
	RobotMap.bLeft.setPosition(0);
	RobotMap.bRight.setPosition(0);
	gearPusher.whenPressed(new GearExtend());
	Robot.swooshencoders.swooshEncoder.reset();

	//Robot.swooshencoders.angleUp(45);
	
}
}
