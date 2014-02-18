package org.usfirst.frc0.Robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static SpeedController driveTrainLeft1;
    public static SpeedController driveTrainLeft2;
    public static Encoder driveTrainLeftEncoder;
    public static SpeedController driveTrainRight1;
    public static SpeedController driveTrainRight2;
    public static Encoder driveTrainRightEncoder;
    public static DoubleSolenoid driveTrainGearSwitchPiston;
    public static Encoder shooterShooterEncoder;
    public static SpeedController shooterShooterMotor;
    public static Solenoid shooterBallReleasePiston;
    public static SpeedController feederIntakeMotor;
    public static DoubleSolenoid feederIntakeMovementPiston;
    public static SpeedController blockerBlockerMovementMotor;
    public static Encoder blockerBlockerMotorEncoder;
    public static DoubleSolenoid blockerBlockerLockingPiston;
    public static Compressor maintenanceCompressor;

    public static void init() {
        driveTrainLeft1 = new Talon(1);
        LiveWindow.addActuator("DriveTrain", "Left1", (Talon) driveTrainLeft1);

        driveTrainLeft2 = new Talon(2);
        LiveWindow.addActuator("DriveTrain", "Left2", (Talon) driveTrainLeft2);

        driveTrainLeftEncoder = new Encoder(1, 2, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "LeftEncoder", driveTrainLeftEncoder);
        driveTrainLeftEncoder.setDistancePerPulse(1.0);
        driveTrainLeftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainLeftEncoder.start();
        driveTrainRight1 = new Talon(3);
        LiveWindow.addActuator("DriveTrain", "Right1", (Talon) driveTrainRight1);

        driveTrainRight2 = new Talon(4);
        LiveWindow.addActuator("DriveTrain", "Right2", (Talon) driveTrainRight2);

        driveTrainRightEncoder = new Encoder(3, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "RightEncoder", driveTrainRightEncoder);
        driveTrainRightEncoder.setDistancePerPulse(1.0);
        driveTrainRightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainRightEncoder.start();
        driveTrainGearSwitchPiston = new DoubleSolenoid(1, 1, 2);

        shooterShooterEncoder = new Encoder(5, 6, false, EncodingType.k4X);
        LiveWindow.addSensor("Shooter", "ShooterEncoder", shooterShooterEncoder);
        shooterShooterEncoder.setDistancePerPulse(1);
        shooterShooterEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        shooterShooterEncoder.start();
        shooterShooterMotor = new Talon(5);
        LiveWindow.addActuator("Shooter", "ShooterMotor", (Talon) shooterShooterMotor);

        shooterBallReleasePiston = new Solenoid(3);

        feederIntakeMotor = new Talon(6);
        LiveWindow.addActuator("Feeder", "IntakeMotor", (Talon) feederIntakeMotor);

        feederIntakeMovementPiston = new DoubleSolenoid(4, 5);

        blockerBlockerMovementMotor = new Talon(7);
        LiveWindow.addActuator("Blocker", "BlockerMovementMotor", (Talon) blockerBlockerMovementMotor);

        blockerBlockerMotorEncoder = new Encoder(7, 8, false, EncodingType.k4X);
        LiveWindow.addSensor("Blocker", "BlockerMotorEncoder", blockerBlockerMotorEncoder);
        blockerBlockerMotorEncoder.setDistancePerPulse(1.0);
        blockerBlockerMotorEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        blockerBlockerMotorEncoder.start();

        blockerBlockerLockingPiston = new DoubleSolenoid(6, 7);

        // maintenanceCompressor = new Compressor(2, 1);
    }
}
