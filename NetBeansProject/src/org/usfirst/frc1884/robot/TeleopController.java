package org.usfirst.frc1884.robot;

import org.usfirst.frc1884.robot.commands.DriveShiftHigh;
import org.usfirst.frc1884.robot.commands.DriveShiftLow;
import org.usfirst.frc1884.robot.commands.DriveShiftSwitch;
import org.usfirst.frc1884.robot.commands.ExtendFeeder;
import org.usfirst.frc1884.robot.commands.ReloadShooter;
import org.usfirst.frc1884.robot.commands.RetractFeeder;
import org.usfirst.frc1884.robot.commands.ShootShooter;
import org.usfirst.frc1884.robot.commands.TeleopDrive;
import org.usfirst.frc1884.robot.oi.OI;
import org.usfirst.frc1884.robot.subsystems.DriveTrain;
import org.usfirst.frc1884.robot.subsystems.Intake;
import org.usfirst.frc1884.robot.subsystems.Shooter;

public class TeleopController {
    public static void init() {
        TeleopDrive.instance.start();
        DriveTrain.instance.startCompressor();
    }
    public static void periodic() {
        if(OI.isBooleanChanged(OI.FLIP_DRIVE) && OI.isBooleanTrue(OI.FLIP_DRIVE)) {
            TeleopDrive.instance.flipDrive();
        }
        if(OI.isBooleanChanged(OI.SWITCH_GEAR) && OI.isBooleanTrue(OI.SWITCH_GEAR)) {
            DriveShiftSwitch.instance.start();
        }
        
        if(OI.isBooleanChanged(OI.SHOOTER_RELOAD) && OI.isBooleanTrue(OI.SHOOTER_RELOAD)) {
            ReloadShooter.instance.start();
        }
        if(OI.isBooleanChanged(OI.SHOOTER_FIRE) && OI.isBooleanTrue(OI.SHOOTER_FIRE)) {
            ShootShooter.instance.start();
        }
    }
}