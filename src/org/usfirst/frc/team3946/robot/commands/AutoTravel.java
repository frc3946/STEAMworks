package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTravel extends Command {
	double went;

    public AutoTravel() {
        // Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
       // requires(Robot.driveTrainEncoder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    	Robot.drivetrain.Drive(.3, -.3);
    	//this.went = Robot.driveTrainEncoder.getRightDistance();
    	Timer.delay(5.0);
    	Robot.drivetrain.Drive(0, 0);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    	
    	//while (this.went <= 275) {
    		//Robot.drivetrain.Drive(.2, -.2);
    		//this.went = Robot.driveTrainEncoder.getRightDistance();
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
