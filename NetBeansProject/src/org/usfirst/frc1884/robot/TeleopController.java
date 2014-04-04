package org.usfirst.frc1884.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc1884.robot.commands.Command;
import org.usfirst.frc1884.robot.commands.DriveShiftHigh;
import org.usfirst.frc1884.robot.commands.DriveShiftLow;
import org.usfirst.frc1884.robot.commands.ExtendFeeder;
import org.usfirst.frc1884.robot.commands.FireAndReload;
import org.usfirst.frc1884.robot.commands.IntakeFeeder;
import org.usfirst.frc1884.robot.commands.OuttakeFeeder;
import org.usfirst.frc1884.robot.commands.RetractFeeder;
import org.usfirst.frc1884.robot.commands.DriveCommand;
import org.usfirst.frc1884.robot.commands.OverrideShooter;
import org.usfirst.frc1884.robot.oi.OI;
import org.usfirst.frc1884.robot.subsystems.Shooter;
import org.usfirst.frc1884.robot.subsystems.Subsystems;

public class TeleopController {

    public static void preinit() {
    }

    public static void init() {
        Shooter.instance.resetEncoder();
    }

    private static long nextTimeCanShoot = 0;

    public static void periodic() {

        //Send Data to SmartDashboard
        SmartDashboard.putBoolean("PID Enabled", OverrideShooter.instance.isPIDEnabled());
        SmartDashboard.putNumber("Motor Value", OverrideShooter.instance.getMotorValue());

        //Run Commands
        DriveCommand.drivePolar(OI.getAnalogValue(OI.DRIVE_FORWARD), OI.getAnalogValue(OI.DRIVE_COUNTERCLOCKWISE));

        if (OI.whenPressed(OI.LOW_GEAR)) {
            DriveShiftLow.instance.start();
        } else if (OI.whenReleased(OI.LOW_GEAR)) {
            DriveShiftHigh.instance.start();
        }

        if (OI.whenReleased(OI.SHOOTER_DISABLE_ENABLE_PID)) {
            if (OverrideShooter.instance.isPIDEnabled()) {
                OverrideShooter.instance.disablePID();
            } else {
                OverrideShooter.instance.enablePID();
            }
        }

        if (!OverrideShooter.instance.isPIDEnabled()) {
            if (OI.whileHeld(OI.SHOOTER_MOVE_FORWARD)) {
                OverrideShooter.instance.setMotorValue(1.0);
            } else if (OI.whileHeld(OI.SHOOTER_MOVE_BACKWARDS)) {
                OverrideShooter.instance.setMotorValue(-1.0);
            } else {
                OverrideShooter.instance.setMotorValue(0);
            }
        } else {
            if (OI.whenPressed(OI.SHOOTER_FIRE)) {
                if (nextTimeCanShoot < System.currentTimeMillis()) {
                    nextTimeCanShoot = System.currentTimeMillis() + 1000;
                    FireAndReload.instance.start();
                }
            }
        }

        if (OI.whenPressed(OI.FEEDER_INTAKE)) {
            IntakeFeeder.instance.start();
        } else if (OI.whenPressed(OI.FEEDER_OUTTAKE)) {
            OuttakeFeeder.instance.start();
        } else if (OI.whenReleased(OI.FEEDER_INTAKE)) {
            IntakeFeeder.instance.finish();
        } else if (OI.whenReleased(OI.FEEDER_OUTTAKE)) {
            OuttakeFeeder.instance.finish();
        }

        if (OI.whenPressed(OI.FEEDER_EXTEND)) {
            ExtendFeeder.instance.start();
        } else if (OI.whenReleased(OI.FEEDER_EXTEND)) {
            RetractFeeder.instance.start();
        }

    }
}
