 package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDrive extends Command {

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftTrain = Robot.oi.driveController0.getY();
    	double rightTrain = Robot.oi.driveController1.getY();
    	//double rightStick = Robot.oi.leftController.getLeftStickY();
    	//double leftStick = Robot.oi.leftController.getRightStickY();
    	Robot.drivetrain.Drive(leftTrain, rightTrain);
    	//Robot.drivetrain.Drive(leftStick, rightStick); //COMMENT OUT IF NOT USING JOYSTICKS. YOU MUST COMMENT TO USE JOYSTICKS
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
