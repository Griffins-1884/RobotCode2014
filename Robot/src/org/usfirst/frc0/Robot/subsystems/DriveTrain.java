package org.usfirst.frc0.Robot.subsystems;

import org.usfirst.frc0.Robot.RobotMap;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc0.Robot.commands.XBoxDrive;

public class DriveTrain extends Subsystem {

    SpeedController left1 = RobotMap.driveTrainLeft1;
    SpeedController left2 = RobotMap.driveTrainLeft2;
    Encoder leftEncoder = RobotMap.driveTrainLeftEncoder;
    SpeedController right1 = RobotMap.driveTrainRight1;
    SpeedController right2 = RobotMap.driveTrainRight2;
    Encoder rightEncoder = RobotMap.driveTrainRightEncoder;
    DoubleSolenoid gearSwitchPiston = RobotMap.driveTrainGearSwitchPiston;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static final long THREAD_POLL_INTERVAL = 250;
    private boolean isHighGear;

    public DriveTrain() {
        leftEncoder.setDistancePerPulse(0.5);
        rightEncoder.setDistancePerPulse(0.5);
        isHighGear = true;
    }

    /**
     * This sets the speed of the Talons on the left side of the motor.
     *
     * @param value The value to set the motors to.
     */
    public void setLeftValues(double value) {
        left1.set(value);
        left2.set(value);
    }

    /**
     * This sets the speed of the Talons on the right side of the motor.
     *
     * @param value The value to set the motors to.
     */
    public void setRightValues(double value) {
        right1.set(value);
        right2.set(value);
    }

    /**
     * This sets the gearbox to the low gear.
     */
    public void setToHighGear() {
        gearSwitchPiston.set(DoubleSolenoid.Value.kForward);
        isHighGear = true;
    }

    /**
     * This sets the gearbox to the high gear.
     */
    public void setToLowGear() {
        gearSwitchPiston.set(DoubleSolenoid.Value.kReverse);
        isHighGear = false;
    }

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        System.out.println("DriveTrain: initDefaultCommand performed");
        setDefaultCommand(new XBoxDrive());
    }

    public void parameterRefresh() {
    }
}
