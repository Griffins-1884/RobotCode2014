package org.usfirst.frc0.Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.Robot.Robot;

public class  SwitchFeeder extends Command {
    private boolean isRetracted;

    public SwitchFeeder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(Robot.feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isRetracted = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Robot.feeder.isArmExtended()) {
            Robot.feeder.retractFeeder();
        } else {
            Robot.feeder.extendFeeder();
        }
        isRetracted = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isRetracted;
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
