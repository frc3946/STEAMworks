package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RobotReverse extends Command {

	public RobotReverse(){
		requires(Robot.climbmotor);
	}
	
	
	protected void initialize() {
	Robot.climbmotor.reverse();
	
	
	}
	protected void  execute() {
	}
	

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
		
	}
  
	protected void end() {
	}
	
	protected void interrupted() {
	}
}
