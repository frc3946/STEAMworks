package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.subsystems.ClimbMotor;
import org.usfirst.frc.team3946.robot.subsystems.LimitSwitch;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RobotReverse extends Command {

    public RobotReverse() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.climbmotor);
         requires(Robot.limitswitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.climbmotor.reverse();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.limitswitch.operatorControl();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climbmotor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}
