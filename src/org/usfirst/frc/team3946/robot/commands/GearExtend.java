package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.subsystems.SwooshEncoders;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearExtend extends Command {
	
	

    public GearExtend() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.swooshencoders);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.swooshencoders.angleUp(90);

        	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.swooshencoders.angleDown(20); THIS GOES RIGHT BACK TO THE 90 DEGREES
    	Robot.swooshencoders.angleDown(-18);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
