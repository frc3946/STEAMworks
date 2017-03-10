package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.commands.WinchStop;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LimitSwitch extends Subsystem {
	
	DigitalInput limitSwitch = new DigitalInput(0);
	Counter counter = new Counter(limitSwitch);

	public void robotInit() {

	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public boolean operatorControl() {
		return counter.get() > 0;
	}

	public void initializeCounter() {
		counter.reset();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
       // setDefaultCommand(new WinchStop());
    }
}

 