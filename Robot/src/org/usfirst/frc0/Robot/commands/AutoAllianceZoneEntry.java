package org.usfirst.frc0.Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.Robot.Robot;
import org.usfirst.frc0.Robot.RobotMap;
import org.usfirst.frc0.Robot.subsystems.SmartDriveTrain;

public class AutoAllianceZoneEntry extends Command implements SmartDriveTrain.DriveListener {

    private SmartDriveTrain sdt;
    private boolean isDriveComplete;

    public AutoAllianceZoneEntry() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isDriveComplete = false;
        sdt = new SmartDriveTrain(this, 48, 1);
        sdt.startTrack();
        sdt.startDrive();
    }

    public void onDriveCompleted() {
        isDriveComplete = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDriveComplete;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
