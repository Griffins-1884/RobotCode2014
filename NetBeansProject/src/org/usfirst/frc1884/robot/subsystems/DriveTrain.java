package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class DriveTrain {
    public static long MILLISECONDS_TO_SHIFT = 100;
    
    private static Talon leftMotor1, leftMotor2, rightMotor1, rightMotor2;
    private static DoubleSolenoid shiftingPiston;
    public static Value SHIFTER_SHIFT_HIGH = DoubleSolenoid.Value.kForward, SHIFTER_SHIFT_LOW = DoubleSolenoid.Value.kReverse, SHIFTER_SHIFT_OFF = DoubleSolenoid.Value.kOff;
    private static long timeToTurnOffShiftingPiston = Long.MAX_VALUE;
    
    private static double leftSidePower = 0.0, rightSidePower = 0.0;
    private static Value shifterSolenoidState = SHIFTER_SHIFT_OFF, shifterActualState = SHIFTER_SHIFT_HIGH;
    
    static {
        leftMotor1 = new Talon(1, 1);
        leftMotor2 = new Talon(1, 2);
        rightMotor1 = new Talon(1, 3);
        rightMotor2 = new Talon(1, 4);
        
        shiftingPiston = new DoubleSolenoid(1, 1, 2);
    }
    
    public static double getLeftSidePower() {
        return leftSidePower;
    }
    public static void setLeftSidePower(double value) {
        leftSidePower = value;
        leftMotor1.set(leftSidePower);
        leftMotor2.set(leftSidePower);
    }
    
    public static double getRightSidePower() {
        return rightSidePower;
    }
    public static void setRightSidePower(double value) {
        rightSidePower = value;
        rightMotor1.set(rightSidePower);
        rightMotor2.set(rightSidePower);
    }
    
    public static Value getShifterSolenoidState() {
        return shifterSolenoidState;
    }
    public static Value getShifterActualState() {
        return shifterActualState;
    }
    public static void setShifterState(Value value) {
        shifterSolenoidState = value;
        if(value != SHIFTER_SHIFT_OFF) {
            shifterActualState = value;
            timeToTurnOffShiftingPiston = System.currentTimeMillis() + MILLISECONDS_TO_SHIFT;
        }
        shiftingPiston.set(shifterSolenoidState);
    }
    
    public static void alwaysRun() {
        if(System.currentTimeMillis() > timeToTurnOffShiftingPiston) {
            timeToTurnOffShiftingPiston = Long.MAX_VALUE;
            setShifterState(SHIFTER_SHIFT_OFF);
        }
    }
    public static void parameterRefresh() {
    }
}
