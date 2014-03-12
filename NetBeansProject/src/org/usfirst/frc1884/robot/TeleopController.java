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
        if(OI.whenPressed(OI.FLIP_DRIVE)) {
            TeleopDrive.instance.flipDrive();
        }
        if(OI.whenPressed(OI.SWITCH_GEAR)) {
            DriveShiftSwitch.instance.start();
        }
        
        if(OI.whenPressed(OI.SHOOTER_RELOAD)) {
            ReloadShooter.instance.start();
        }
        if(OI.whenPressed(OI.SHOOTER_FIRE)) {
            ShootShooter.instance.start();
        }
    }
}