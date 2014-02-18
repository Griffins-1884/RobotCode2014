package org.usfirst.frc0.Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.Robot.Robot;

public class  SwitchGears extends Command {

    private boolean isSwitched;
    private boolean isInitHigh; //is the inital value high gear
    
    public SwitchGears() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isSwitched = false;
        isInitHigh = Robot.driveTrain.getGearStatus();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (isInitHigh) {
            Robot.driveTrain.setToLowGear();
        } else {
            Robot.driveTrain.setToHighGear();
        }
        isSwitched = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isSwitched;
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
