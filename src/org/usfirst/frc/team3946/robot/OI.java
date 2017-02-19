package org.usfirst.frc.team3946.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3946.robot.commands.RobotForward;
import org.usfirst.frc.team3946.robot.commands.RobotReverse;
import edu.wpi.first.wpilibj.Joystick;
import libraries.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public Joystick driveController0 = new Joystick(0);
	public Joystick driveController1 = new Joystick(1);
	public XboxController leftController = new XboxController(3);
	Button winchButtonUp = new JoystickButton(driveController1, 1);
	Button winchButtonDown = new JoystickButton(driveController0, 1);
	


	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());


public OI() {
	winchButtonUp.whenPressed(new RobotForward());
	winchButtonDown.whenPressed(new RobotReverse());
	
	
}

}
