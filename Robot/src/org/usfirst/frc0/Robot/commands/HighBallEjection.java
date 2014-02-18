package org.usfirst.frc0.Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc0.Robot.Robot;
import org.usfirst.frc0.Robot.subsystems.Shooter;

public class HighBallEjection extends Command {

    public static final long FEEDER_WAITING_TIME = 1000;

    private boolean wasPreviouslyExtended;

    public HighBallEjection() {
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.shooter.enable();
        Robot.shooter.setSetpoint(Shooter.STARTING_POSITION);

        wasPreviouslyExtended = Robot.feeder.isArmExtended();

    }

    // Called repeatedly when this Command is scheduled to run
    long timeStartedWaiting = -1;

    protected void execute() {

        Robot.shooter.printEncoder();

        if (!Robot.feeder.isArmExtended()) {
            Robot.feeder.extendFeeder();
            timeStartedWaiting = System.currentTimeMillis();
        } else if (timeStartedWaiting + FEEDER_WAITING_TIME < System.currentTimeMillis()) {
            Robot.shooter.setSetpoint(Shooter.FIRE);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.onTarget();
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
