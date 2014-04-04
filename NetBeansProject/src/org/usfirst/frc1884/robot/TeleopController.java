package org.usfirst.frc1884.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc1884.robot.commands.Command;
import org.usfirst.frc1884.robot.commands.DriveShiftHigh;
import org.usfirst.frc1884.robot.commands.DriveShiftLow;
import org.usfirst.frc1884.robot.commands.ExtendFeeder;
import org.usfirst.frc1884.robot.commands.FireAndReloadWithLimitSwitch;
import org.usfirst.frc1884.robot.commands.IntakeFeeder;
import org.usfirst.frc1884.robot.commands.OuttakeFeeder;
import org.usfirst.frc1884.robot.commands.RetractFeeder;
import org.usfirst.frc1884.robot.commands.DriveCommand;
import org.usfirst.frc1884.robot.commands.ShooterOverride;
import org.usfirst.frc1884.robot.oi.OI;
import org.usfirst.frc1884.robot.subsystems.Shooter;

public class TeleopController {
    public static void preinit() {
    }
    public static void init() {
//        Shooter.instance.resetEncoder();
    }
    public static void periodic() {
        
        //Send values to SmartDashboard
        
        SmartDashboard.putNumber("Choo Choo Power", Shooter.instance.getMotorPower());
        SmartDashboard.putBoolean("Limit Switch Enabled", ShooterOverride.isLimitSwitchEnabled());
        
        //Run Commands
        
        DriveCommand.drivePolar(OI.getAnalogValue(OI.DRIVE_FORWARD), OI.getAnalogValue(OI.DRIVE_COUNTERCLOCKWISE));
        
        if(OI.whenPressed(OI.LOW_GEAR)) {
            DriveShiftLow.instance.start();
        } else if(OI.whenReleased(OI.LOW_GEAR)) {
            DriveShiftHigh.instance.start();
        }
        
        if(OI.whenPressed(OI.SHOOTER_ENABLE_DISABLE_LIMIT_SWITCH)) {
            if(ShooterOverride.isLimitSwitchEnabled()) {
                ShooterOverride.disableLimitSwitch();
            } else {
                ShooterOverride.enableLimitSwitch();
            }
        }
        
        if(ShooterOverride.isLimitSwitchEnabled()) {
        if(OI.whenPressed(OI.SHOOTER_FIRE)) {
            if(FireAndReloadWithLimitSwitch.instance.state == Command.NOT_RUNNING) {
                FireAndReloadWithLimitSwitch.instance.start();
            }
        }
        } else {
            if(OI.whileHeld(OI.SHOOTER_FIRE_FORWARD)) {
                ShooterOverride.setMotorValue(1.0);
            } else if(OI.whileHeld(OI.SHOOTER_FIRE_BACKWARD)) {
                ShooterOverride.setMotorValue(-1.0);
            } else {
                ShooterOverride.setMotorValue(0.0);
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