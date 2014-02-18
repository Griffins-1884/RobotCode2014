package org.usfirst.frc0.Robot.subsystems;

import org.usfirst.frc0.Robot.RobotMap;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Feeder extends Subsystem {

    SpeedController intakeMotor = RobotMap.feederIntakeMotor;
    DoubleSolenoid intakeMovementPiston = RobotMap.feederIntakeMovementPiston;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private double speed;
    private boolean isExtended;
    private static long PISTON_MOVE_TIME = 1500;

    /**
     * This returns true if the arm is extended, false if otherwise.
     *
     * @return True if the arm is extended. False if the arm is retracted.
     */
    public boolean isArmExtended() {
        return isExtended;
    }

    /**
     * This extends the Feeder arm.
     */
    public void extendFeeder() {
        intakeMovementPiston.set(DoubleSolenoid.Value.kForward);
    }

    /**
     * This retracts the Feeder arm.
     */
    public void retractFeeder() {
        intakeMovementPiston.set(DoubleSolenoid.Value.kReverse);
    }

    /**
     * This rolls the Feeder in.
     */
    public void rollIn() {
        intakeMotor.set(speed);
    }

    /**
     * This rolls the Feeder in reverse.
     */
    public void rollOut() {
        intakeMotor.set(-speed);
    }

    /**
     * This stops the Feeder roll.
     */
    public void noRoll() {
        intakeMotor.set(0);
    }

    /**
     * Set the intake speed of the motor. This should be between 0 and 1.
     *
     * @param speed The intake speed to set the motor to.
     */
    public void setIntakeSpeed(double speed) {
        this.speed = speed;
    }

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        this.speed = 1;
        this.isExtended = false;
    }

    public void parameterRefresh() {
    }
}
