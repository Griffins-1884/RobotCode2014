package org.usfirst.frc0.Robot.subsystems;

import org.usfirst.frc0.Robot.RobotMap;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Blocker extends PIDSubsystem {

    SpeedController blockerMovementMotor = RobotMap.blockerBlockerMovementMotor;
    Encoder blockerMotorEncoder = RobotMap.blockerBlockerMotorEncoder;
    DoubleSolenoid blockerLockingPiston = RobotMap.blockerBlockerLockingPiston;

    public static final byte EXTENDED = 51;
    public static final byte RETRACTED = 52;

    // Initialize your subsystem here
    public Blocker() {
        super("Blocker", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Blocker", "PIDSubsystem Controller", getPIDController());
        getPIDController().setOutputRange(-1.0, 1.0);

        blockerLockingPiston.set(DoubleSolenoid.Value.kReverse);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void extendPiston() {
        blockerLockingPiston.set(DoubleSolenoid.Value.kForward);
    }

    public void retractPiston() {
        blockerLockingPiston.set(DoubleSolenoid.Value.kReverse);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        return blockerMotorEncoder.pidGet();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        blockerMovementMotor.pidWrite(output);
    }

    public void parameterRefresh() {
    }
}
