package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake {
    public static long MILLISECONDS_TO_EXTEND = 1000;
    
    private static Talon intakeMotor;
    private static DoubleSolenoid extendingPiston;
    public static Value EXTENDER_EXTEND = DoubleSolenoid.Value.kForward, EXTENDER_RETRACT = DoubleSolenoid.Value.kReverse, EXTENDER_OFF = DoubleSolenoid.Value.kOff;
    private static long timeToTurnOffShiftingPiston = Long.MAX_VALUE;
    
    private static double intakePower = 0.0;
    private static Value extenderSolenoidState = EXTENDER_OFF, extenderActualState = EXTENDER_RETRACT;
    
    static {
        intakeMotor = new Talon(1, 6);
        
        extendingPiston = new DoubleSolenoid(1, 3, 4);
    }
    
    public static double getIntakePower() {
        return intakePower;
    }
    public static void setIntakePower(double value) {
        intakePower = value;
        intakeMotor.set(intakePower);
    }
    
    public static Value getExtenderSolenoidState() {
        return extenderSolenoidState;
    }
    public static Value getExtenderActualState() {
        return extenderActualState;
    }
    public static void setExtenderState(Value value) {
        extenderSolenoidState = value;
        if(value != EXTENDER_OFF) {
            extenderActualState = value;
            timeToTurnOffShiftingPiston = System.currentTimeMillis() + MILLISECONDS_TO_EXTEND;
        }
        extendingPiston.set(extenderSolenoidState);
    }
    
    public static void alwaysRun() {
        if(System.currentTimeMillis() > timeToTurnOffShiftingPiston) {
            timeToTurnOffShiftingPiston = Long.MAX_VALUE;
            setExtenderState(EXTENDER_OFF);
        }
    }
    public static void parameterRefresh() {
    }
}
