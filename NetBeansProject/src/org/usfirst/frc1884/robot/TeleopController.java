package org.usfirst.frc1884.robot;

import org.usfirst.frc1884.robot.commands.Command;
import org.usfirst.frc1884.robot.commands.DriveShiftHigh;
import org.usfirst.frc1884.robot.commands.DriveShiftLow;
import org.usfirst.frc1884.robot.commands.ExtendFeeder;
import org.usfirst.frc1884.robot.commands.FireAndReload;
import org.usfirst.frc1884.robot.commands.IntakeFeeder;
import org.usfirst.frc1884.robot.commands.OuttakeFeeder;
import org.usfirst.frc1884.robot.commands.RetractFeeder;
import org.usfirst.frc1884.robot.commands.DriveCommand;
import org.usfirst.frc1884.robot.oi.OI;
import org.usfirst.frc1884.robot.subsystems.Shooter;

public class TeleopController {
    public static void preinit() {
    }
    public static void init() {
        Shooter.instance.resetEncoder();
    }
    public static void periodic() {
        //Run Commands
        
        DriveCommand.drivePolar(OI.getAnalogValue(OI.DRIVE_FORWARD), OI.getAnalogValue(OI.DRIVE_COUNTERCLOCKWISE));
        
        if(OI.whenPressed(OI.LOW_GEAR)) {
            DriveShiftLow.instance.start();
        } else if(OI.whenReleased(OI.LOW_GEAR)) {
            DriveShiftHigh.instance.start();
        }
        
        if(OI.whenPressed(OI.SHOOTER_FIRE)) {
            if(FireAndReload.instance.state == Command.NOT_RUNNING) {
                FireAndReload.instance.start();
            }
        }
        
        if(OI.whenPressed(OI.FEEDER_INTAKE)) {
            IntakeFeeder.instance.start();
        } else if(OI.whenPressed(OI.FEEDER_OUTTAKE)) {
            OuttakeFeeder.instance.start();
        } else if(OI.whenReleased(OI.FEEDER_INTAKE)) {
            IntakeFeeder.instance.finish();
        } else if(OI.whenReleased(OI.FEEDER_OUTTAKE)) {
            OuttakeFeeder.instance.finish();
        }
        
        if(OI.whenPressed(OI.FEEDER_EXTEND)) {
            ExtendFeeder.instance.start();
        } else if(OI.whenReleased(OI.FEEDER_EXTEND)) {
            RetractFeeder.instance.start();
        }
        
    }
}