package org.usfirst.frc1884.robot;

import org.usfirst.frc1884.robot.commands.DriveShiftSwitch;
import org.usfirst.frc1884.robot.commands.ExtendFeeder;
import org.usfirst.frc1884.robot.commands.IntakeFeeder;
import org.usfirst.frc1884.robot.commands.OuttakeFeeder;
import org.usfirst.frc1884.robot.commands.ReloadShooter;
import org.usfirst.frc1884.robot.commands.RetractFeeder;
import org.usfirst.frc1884.robot.commands.ShootShooter;
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
            TeleopDrive.instance.flipDrive();
        }
        if(OI.whenPressed(OI.SWITCH_GEAR)) {
            DriveShiftSwitch.instance.start();
        }
        
        if(OI.whenPressed(OI.SHOOTER_FIRE)) {
            ShootShooter.instance.start();
        } else if(OI.whenPressed(OI.SHOOTER_RELOAD)) {
            ReloadShooter.instance.start();
        } else if(OI.whenReleased(OI.SHOOTER_FIRE)) {
            ShootShooter.instance.finish();
        } else if(OI.whenReleased(OI.SHOOTER_RELOAD)) {
            ReloadShooter.instance.finish();
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