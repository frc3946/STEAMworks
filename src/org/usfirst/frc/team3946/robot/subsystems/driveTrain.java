package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class driveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon fRight = new CANTalon(RobotMap.fRightDriveTalon);
    public CANTalon fLeft = new CANTalon(RobotMap.fLeftDriveTalon);
    public CANTalon bRight = new CANTalon(RobotMap.bRightDriveTalon);
    public CANTalon bLeft = new CANTalon(RobotMap.bLeftDriveTalon);
//    public RobotDrive robotDrive = new RobotDrive(fLeft, bLeft, fRight, bRight);
    public RobotDrive robotDrive = new RobotDrive(fLeft, fRight);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    //    setDefaultCommand(tankDrive());
    }
    public void Drive(double speedLeft, double speedRight){
    	fRight.set(speedRight);
    	fLeft.set(speedLeft);
    	bRight.set(speedRight);
    	bLeft.set(speedLeft);
}
}

