package org.usfirst.frc.team3946.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3946.robot.commands.RobotClimb;
import org.usfirst.frc.team3946.robot.commands.UltimateGoBack;
import org.usfirst.frc.team3946.robot.commands.WinchClinch;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

import libraries.XboxController;

import org.usfirst.frc.team3946.robot.commands.WinchStop;
import org.usfirst.frc.team3946.robot.commands.GearExtend;
import org.usfirst.frc.team3946.robot.commands.ManualAlign;
import org.usfirst.frc.team3946.robot.commands.AutoLeftTurnCycle;
import org.usfirst.frc.team3946.robot.commands.ManualSet;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick driveController1 = new Joystick(0);
	public Joystick driveController2 = new Joystick(1);
	Button winchButtonUp = new JoystickButton(driveController2, 10);
	Button winchButtonDown = new JoystickButton(driveController1, 5);
	Button gearPusher = new JoystickButton(driveController2, 3);
	Button manual90 = new JoystickButton(driveController2, 4);
	Button manualSTOP = new JoystickButton(driveController2, 11);
	Button manualSetToZero = new JoystickButton(driveController1, 3);
	
	
	
	public XboxController leftController = new XboxController(2);
//	Button 
	
	
	
	

public OI() {
	winchButtonUp.whenPressed(new RobotClimb());
	manualSTOP.whenPressed(new WinchClinch());
	winchButtonDown.whenPressed(new WinchStop());
	gearPusher.whenPressed(new GearExtend());
	Robot.swooshencoders.swooshEncoder.reset();
	//manual90.whenPressed(new AutoLeftTurnCycle());
	manualSetToZero.whenPressed(new UltimateGoBack());
	

}
}
