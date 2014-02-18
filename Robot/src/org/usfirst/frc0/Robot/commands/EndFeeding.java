package org.usfirst.frc0.Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.Robot.Robot;

public class EndFeeding extends Command {

    private boolean isNotRolling;

    public EndFeeding() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(Robot.feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isNotRolling = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.feeder.noRoll();
        isNotRolling = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isNotRolling;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
