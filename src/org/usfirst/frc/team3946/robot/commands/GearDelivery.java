package org.usfirst.frc.team3946.robot.commands;

import org.usfirst.frc.team3946.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearDelivery extends CommandGroup {

    public GearDelivery() {
	    double distance = Robot.driveTrainEncoder.getRightDistance();
		SmartDashboard.putNumber("Actual Right Distance",
			Robot.driveTrainEncoder.getRightDistance());
		Robot.drivetrain.Drive(-0.4, -0.4);
		if (distance >= 120) {
			Robot.drivetrain.Drive(0.0, 0.0);
			Timer.delay(3.0);
			Robot.drivetrain.Drive(0.4, 0.4);
				if (distance <= 0) {
				Robot.drivetrain.Drive(0.0, 0.0);
		} 
	}
    }
}
