package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;
import org.usfirst.frc.team3946.robot.subsystems.SwooshEncoders;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetGearUpright extends Command {
	
	

    public SetGearUpright() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.swooshencoders);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.swooshencoders.angle45();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean test1 = RobotMap.lightOne.get();
      	boolean test2 = RobotMap.lightTwo.get();
      	boolean test3 = RobotMap.lightThree.get();
       	if (test1 == true || test2 == true || test3 == true) {
    			Robot.swooshencoders.angle90();
        	}
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
