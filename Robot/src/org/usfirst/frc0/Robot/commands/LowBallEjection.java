// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc0.Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.Robot.Robot;

/**
 *
 */
public class LowBallEjection extends Command {

    private boolean isEjected;
    public static final long PISTON_RAISE_TIME = 150;

    public LowBallEjection() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.shooter);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isEjected = false;
        timeStarted = System.currentTimeMillis();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
    }

    private long timeStarted;

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (System.currentTimeMillis() - timeStarted < PISTON_RAISE_TIME) {
            Robot.shooter.enablePiston();
        } else {
            Robot.shooter.disablePiston();
        }
        isEjected = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
        return isEjected;
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.maintenance.compressAir();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
