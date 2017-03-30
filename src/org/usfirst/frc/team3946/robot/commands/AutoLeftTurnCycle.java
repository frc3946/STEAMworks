package org.usfirst.frc.team3946.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftTurnCycle extends CommandGroup {

    public AutoLeftTurnCycle() {
        // Add Commands here:
       addSequential(new AutoTravel());
       addSequential(new EncoderTurnLeft());
       addSequential(new DriveUntilGearPlace());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel(
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
