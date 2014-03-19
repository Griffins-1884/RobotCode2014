package org.usfirst.frc1884.robot;

import org.usfirst.frc1884.robot.commands.Command;
import org.usfirst.frc1884.robot.commands.DriveShiftHigh;
import org.usfirst.frc1884.robot.commands.DriveShiftLow;
import org.usfirst.frc1884.robot.commands.DriveShiftSwitch;
import org.usfirst.frc1884.robot.commands.ExtendFeeder;
import org.usfirst.frc1884.robot.commands.FireAndReload;
import org.usfirst.frc1884.robot.commands.IntakeFeeder;
import org.usfirst.frc1884.robot.commands.OuttakeFeeder;
import org.usfirst.frc1884.robot.commands.RetractFeeder;
import org.usfirst.frc1884.robot.commands.TeleopDrive;
import org.usfirst.frc1884.robot.oi.OI;
import org.usfirst.frc1884.robot.subsystems.DriveTrain;

public class TeleopController {
    public static void init() {
        TeleopDrive.instance.start();
        DriveTrain.instance.startCompressor();
    }
    public static void periodic() {
        if(OI.whenPressed(OI.FLIP_DRIVE)) {
            TeleopDrive.instance.toggleFlipDrive();
        }
        if(OI.whenPressed(OI.KEEP_DRIVE_REVERSED)) {
            TeleopDrive.instance.flipDrive(true);
        } else if(OI.whenReleased(OI.KEEP_DRIVE_REVERSED)) {
            TeleopDrive.instance.flipDrive(false);
        }
        
        if(OI.whenPressed(OI.SWITCH_GEAR)) {
            DriveShiftSwitch.instance.start();
        }
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