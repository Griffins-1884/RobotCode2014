package org.usfirst.frc0.Robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.Robot.Robot;
import org.usfirst.frc0.Robot.oi.Controller2014;

public class DriveCommand extends Command {

    public DriveCommand() {
        requires(Robot.driveTrain);
    }

    protected void initialize() {
        //do something here
    }

    protected void execute() {
        double forward = Robot.oi.controller.getAnalog(Controller2014.DRIVE_FORWARD),
               counterclockwise = Robot.oi.controller.getAnalog(Controller2014.DRIVE_COUNTERCLOCKWISE);
        double leftValue = forward - counterclockwise,
               rightValue = -forward - counterclockwise;
        Robot.driveTrain.setLeftValues(Math.max(Math.min(leftValue, 1.0), -1.0));
        Robot.driveTrain.setRightValues(Math.max(Math.min(rightValue, 1.0), -1.0));
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
