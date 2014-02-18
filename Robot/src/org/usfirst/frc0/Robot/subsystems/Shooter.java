package org.usfirst.frc0.Robot.subsystems;

import org.usfirst.frc0.Robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc0.util.DoubleParameter;
import org.usfirst.frc0.util.Parameter;

public class Shooter extends PIDSubsystem {

    Encoder shooterEncoder = RobotMap.shooterShooterEncoder;
    SpeedController shooterMotor = RobotMap.shooterShooterMotor;

    public static final double STARTING_POSITION = 0;
    public static final double FIRE = 1d / 360d;
    private DoubleParameter P = DoubleParameter.get("Shooter - P"),
            I = DoubleParameter.get("Shooter - I"),
            D = DoubleParameter.get("Shooter - D");

    // Initialize your subsystem here
    public Shooter() {
        super("Shooter", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(true);
        LiveWindow.addActuator("Shooter", "PIDSubsystem Controller", getPIDController());
        getPIDController().setOutputRange(/*-1.0*/-1d, /*1.0*/ 1d);
        enable();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        return shooterEncoder.pidGet();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        shooterMotor.pidWrite(output);
    }

    public void printEncoder() {
        System.out.println(shooterEncoder.get());
        System.out.println("PID " + shooterEncoder.pidGet());
    }

    public void parameterRefresh() {
        super.getPIDController().setPID(P.getValue(), I.getValue(), D.getValue());
    }
}
