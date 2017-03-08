package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RobotClimb extends Command {

	AnalogInput fingerTip = new AnalogInput(0);
    public RobotClimb() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.climbmotor);
    	}

    // Called just before this Command runs the first time
    protected void initialize() {
    Robot.climbmotor.forward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true; 	
 
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
