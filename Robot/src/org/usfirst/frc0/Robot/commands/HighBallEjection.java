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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc0.Robot.Robot;
import org.usfirst.frc0.Robot.subsystems.Shooter;

/**
 *
 */
public class  HighBallEjection extends Command {
    
    public static final long FEEDER_WAITING_TIME = 1000;
    
    private boolean wasPreviouslyExtended;

    public HighBallEjection() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.shooter);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        Robot.shooter.enable();
        Robot.shooter.setSetpoint(Shooter.STARTING_POSITION);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INITIALIZE
        
        wasPreviouslyExtended = Robot.feeder.isArmExtended();
        
    }

    // Called repeatedly when this Command is scheduled to run
    long timeStartedWaiting = -1;
    protected void execute() {
        
        Robot.shooter.printEncoder();
        
        if(!Robot.feeder.isArmExtended()) {
            Robot.feeder.extendFeeder();
            timeStartedWaiting = System.currentTimeMillis();
        } else if(timeStartedWaiting + FEEDER_WAITING_TIME < System.currentTimeMillis()) {
            Robot.shooter.setSetpoint(Shooter.FIRE);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
        return Robot.shooter.onTarget();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.shooter.setSetpoint(Shooter.STARTING_POSITION);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.shooter.setSetpoint(Shooter.STARTING_POSITION);
    }
}
