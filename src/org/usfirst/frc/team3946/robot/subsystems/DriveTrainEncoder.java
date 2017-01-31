package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrainEncoder extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Encoder rightEncoder = new Encoder(RobotMap.rightWheelEncoderA, RobotMap.rightWheelEncoderB, true, EncodingType.k4X);
    Encoder leftEncoder = new Encoder(RobotMap.leftWheelEncoderA, RobotMap.leftWheelEncoderB, true, EncodingType.k4X);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
        public void initEncoders(){
        	//6'11"=83 inches per 3430 ticks (unsure what this comment is)
        	rightEncoder.setDistancePerPulse((3.14*(6.0/12.0))/360.0); // inches /ticks
        	rightEncoder.setMinRate(.1);
        	rightEncoder.setSamplesToAverage(7);
        	leftEncoder.setDistancePerPulse((3.14*(6.0/12.0))/360.0); // inches /ticks
        	leftEncoder.setMinRate(.1);
        	leftEncoder.setSamplesToAverage(7);
        }
        
        public double getRightDistance()
        {
        	return rightEncoder.getDistance();
        }
        
        public double getRightRate()
        {
        	return rightEncoder.getRate();
        	
        }
        public double getLeftDistance()
        {
        	return leftEncoder.getDistance();
        }
        
        public double getLeftRate()
        {
        	return leftEncoder.getRate();
        	
        }
        
        public double getAverageDistance(){
        	return (getLeftDistance() + getRightDistance()) / 2;
        }
        
        public void resetEncoders(){
        	leftEncoder.reset();
        	rightEncoder.reset();
        }
    }
