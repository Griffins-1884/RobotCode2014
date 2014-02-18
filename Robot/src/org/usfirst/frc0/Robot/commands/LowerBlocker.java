package org.usfirst.frc0.Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.Robot.Robot;
import org.usfirst.frc0.Robot.subsystems.Blocker;

public class LowerBlocker extends Command {

    public LowerBlocker() {
        requires(Robot.blocker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.blocker.enable();
        Robot.blocker.setSetpoint(1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.blocker.retractPiston();
        Robot.blocker.setSetpoint(Blocker.RETRACTED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.blocker.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
