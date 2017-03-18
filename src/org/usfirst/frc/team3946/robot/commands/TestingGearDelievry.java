package org.usfirst.frc.team3946.robot.commands;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;


public class TestingGearDelievry extends IterativeRobot {


	
	Joystick driveController1 = new Joystick(0);
	Joystick driveController2 = new Joystick(1);
	
	
//	public CANTalon bRight = new CANTalon(1);
	public CANTalon bLeft = new CANTalon(2);
	public CANTalon fRight = new CANTalon(3);
	public CANTalon fLeft = new CANTalon(4);
	
	public void teleopPeriodic() {
		
		double axis = driveController1.getY();
//		bRight.set(axis);
		bLeft.set(axis);
		fRight.set(axis);
		fLeft.set(axis);		
	}
	
	
}