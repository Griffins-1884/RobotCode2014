package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intake extends Subsystem {
    public static final Intake instance;
    static {
        instance = new Intake();
        Subsystems.registerSubsystem(instance);
    }
    public static long MILLISECONDS_TO_EXTEND = 1000;
    
    private Talon intakeMotor;
    private DoubleSolenoid extendingPiston;
    public static final Value EXTENDER_EXTEND = DoubleSolenoid.Value.kForward, EXTENDER_RETRACT = DoubleSolenoid.Value.kReverse, EXTENDER_OFF = DoubleSolenoid.Value.kOff;
    private long timeToTurnOffShiftingPiston = Long.MAX_VALUE;
    
    private double intakePower = 0.0;
    private Value extenderSolenoidState = EXTENDER_OFF, extenderActualState = EXTENDER_RETRACT;
    
    private Intake() {
        intakeMotor = new Talon(1, 6);
        
        extendingPiston = new DoubleSolenoid(1, 4, 3);
    }
    
    public double getIntakePower() {
        return intakePower;
    }
    public void setIntakePower(double value) {
        intakePower = value;
        intakeMotor.set(intakePower);
    }
    
    public Value getExtenderSolenoidState() {
        return extenderSolenoidState;
    }
    public Value getExtenderActualState() {
        return extenderActualState;
    }
    public void setExtenderState(Value value) {
        extenderSolenoidState = value;
        if(value != EXTENDER_OFF) {
            extenderActualState = value;
            timeToTurnOffShiftingPiston = System.currentTimeMillis() + MILLISECONDS_TO_EXTEND;
        }
        extendingPiston.set(extenderSolenoidState);
    }
    
    public void alwaysRun() {
        if(System.currentTimeMillis() > timeToTurnOffShiftingPiston) {
            timeToTurnOffShiftingPiston = Long.MAX_VALUE;
            setExtenderState(EXTENDER_OFF);
        }
    }
    public void disable() {
        this.setIntakePower(0.0);
    }
    public void parameterRefresh() {
    }
}
