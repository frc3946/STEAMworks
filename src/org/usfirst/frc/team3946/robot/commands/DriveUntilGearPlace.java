package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveUntilGearPlace extends Command {
	double finalLeg;
    public DriveUntilGearPlace() {
        // Use requires() here to declare subsystem dependencies
      requires(Robot.driveTrainEncoder);
      requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.bLeft.setPosition(0);
    	RobotMap.bRight.setPosition(0);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.drivetrain.Drive(.3, -.3);
    		Timer.delay(1.5);
    		Robot.drivetrain.Drive(0, 0);
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
