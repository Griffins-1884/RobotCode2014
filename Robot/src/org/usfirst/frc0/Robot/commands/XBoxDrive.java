package org.usfirst.frc0.Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.Robot.Robot;

public class XBoxDrive extends Command {

    public XBoxDrive() {
        requires(Robot.driveTrain);
    }

    protected void initialize() {
        //do something here
    }

    protected void execute() {
        Robot.driveTrain.setLeftValues(Robot.oi.getLeftSpeed());
        Robot.driveTrain.setRightValues(-Robot.oi.getRightSpeed());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.driveTrain.setLeftValues(0);
        Robot.driveTrain.setRightValues(0);
    }

    protected void interrupted() {
        Robot.driveTrain.setLeftValues(0);
        Robot.driveTrain.setRightValues(0);
    }

    protected void stop() {

    }

}
