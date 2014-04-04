package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class DriveTrain extends Subsystem {
    public static final DriveTrain instance;
    static {
        instance = new DriveTrain();
        Subsystems.registerSubsystem(instance);
    }
    public static long MILLISECONDS_TO_SHIFT = 100;
    
    private Talon leftMotor1, leftMotor2, rightMotor1, rightMotor2;
    private DoubleSolenoid shiftingPiston;
    public static final Value SHIFTER_SHIFT_HIGH = DoubleSolenoid.Value.kForward, SHIFTER_SHIFT_LOW = DoubleSolenoid.Value.kReverse, SHIFTER_SHIFT_OFF = DoubleSolenoid.Value.kOff;
    private long timeToTurnOffShiftingPiston = Long.MAX_VALUE;
    
    private double leftSidePower = 0.0, rightSidePower = 0.0;
    private Value shifterSolenoidState = SHIFTER_SHIFT_OFF, shifterActualState = SHIFTER_SHIFT_HIGH;
    
    private Compressor compressor;
    
    private DriveTrain() {
        leftMotor1 = new Talon(1, 3);
        leftMotor2 = new Talon(1, 4);
        rightMotor1 = new Talon(1, 1);
        rightMotor2 = new Talon(1, 2);
        
        shiftingPiston = new DoubleSolenoid(1, 1, 2);
        
        compressor = new Compressor(1, 2, 1, 1);
    }
    
    public double getLeftSidePower() {
        return leftSidePower;
    }
    public void setLeftSidePower(double value) {
        leftSidePower = value;
        leftMotor1.set(leftSidePower);
        leftMotor2.set(leftSidePower);
    }
    
    public double getRightSidePower() {
        return rightSidePower;
    }
    public void setRightSidePower(double value) {
        rightSidePower = value;
        rightMotor1.set(rightSidePower);
        rightMotor2.set(rightSidePower);
    }
    
    public Value getShifterSolenoidState() {
        return shifterSolenoidState;
    }
    public Value getShifterActualState() {
        return shifterActualState;
    }
    public void setShifterState(Value value) {
        shifterSolenoidState = value;
        if(value != SHIFTER_SHIFT_OFF) {
            shifterActualState = value;
            timeToTurnOffShiftingPiston = System.currentTimeMillis() + MILLISECONDS_TO_SHIFT;
        }
        shiftingPiston.set(shifterSolenoidState);
    }
    
    public void startCompressor() {
        compressor.start();
    }
    public void stopCompressor() {
        compressor.stop();
    }
    
    public void alwaysRun() {
        if(System.currentTimeMillis() > timeToTurnOffShiftingPiston) {
            timeToTurnOffShiftingPiston = Long.MAX_VALUE;
            setShifterState(SHIFTER_SHIFT_OFF);
        }
    }
    public void disable() {
        this.setLeftSidePower(0.0);
        this.setRightSidePower(0.0);
    }
    public void parameterRefresh() {
    }
}
