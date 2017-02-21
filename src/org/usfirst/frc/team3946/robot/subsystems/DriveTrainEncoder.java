package org.usfirst.frc.team3946.robot.subsystems;

import org.usfirst.frc.team3946.robot.RobotMap;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANSpeedController;
import org.usfirst.frc.team3946.robot.subsystems.DriveTrain;
/**
 *
 */
public class DriveTrainEncoder extends Subsystem {

	double ticksCal = 19.11; //360 divided by wheel diameter times 3.14 
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Encoder rightEncoder = new Encoder(RobotMap.rightWheelEncoderA, RobotMap.rightWheelEncoderB, true, Encoder.EncodingType.k4X);
    //Encoder leftEncoder = new Encoder(RobotMap.leftWheelEncoderA, RobotMap.leftWheelEncoderB, true, Encoder.EncodingType.k4X);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
    }
        public void initEncoders(){
    		RobotMap.bLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    		RobotMap.bRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    		RobotMap.bRight.configEncoderCodesPerRev(360);
    		RobotMap.bLeft.configEncoderCodesPerRev(360);	

        	
        }
        
        public double getRightDistance()
        {
        	double rawData = RobotMap.bRight.getEncPosition();
        	return - rawData/ticksCal;
        	
        }
        
        	
        public double getLeftDistance()
        {
        	double rawLeftData = RobotMap.bLeft.getEncPosition();
        	return rawLeftData/ticksCal;
        }
        
        public void stopEncoders()
        {
    		RobotMap.bRight.setEncPosition(0);
    		RobotMap.bLeft.setEncPosition(0);
        }
       
}
