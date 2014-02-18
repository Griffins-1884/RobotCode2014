/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc0.Robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.Robot.Robot;

/**
 *
 * @author jwang
 */
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
