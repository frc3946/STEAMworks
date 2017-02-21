package org.usfirst.frc.team3946.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LimitSwitch extends Subsystem {
	
	DigitalInput limitSwitch;

	public void robotInit() {
		limitSwitch = new DigitalInput(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public boolean operatorControl() {
		return limitSwitch.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

