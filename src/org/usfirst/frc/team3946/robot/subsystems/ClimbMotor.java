package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.Robot;
import org.usfirst.frc.team3946.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbMotor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Talon winchMotor = new Talon(RobotMap.winchTalon);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void forward() {
    	winchMotor.set(1.0);
    	
    }
    public void reverse() {
	winchMotor.set(-0.5);
    }
    public void stop() {
    	winchMotor.set(0.0);
    }
}

