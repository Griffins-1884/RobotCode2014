package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc1884.util.pid.PIDEncoderTalonController;

public class Blocker {
    public static long MILLISECONDS_TO_BLOCK_OR_UNBLOCK = 100;
    
    private static Talon blockerMotor;
    private static Encoder blockerEncoder;
    private static PIDController blockerPIDController;
    private static DoubleSolenoid blockerLockingPiston;
    public static Value BLOCKER_LOCK_LOCK = DoubleSolenoid.Value.kForward, BLOCKER_LOCK_UNLOCK = DoubleSolenoid.Value.kReverse, BLOCKER_LOCK_OFF = DoubleSolenoid.Value.kOff;
    private static long timeToTurnOffBlockerLockingPiston = Long.MAX_VALUE;
    
    private static Value blockerLockState = BLOCKER_LOCK_OFF;
    private static double goalPoint = 0.0;
    
    static {
        blockerMotor = new Talon(1, 7);
        blockerEncoder = new Encoder(1, 9, 1, 10);
        blockerPIDController = new PIDEncoderTalonController(1.0, 0.0, 0.0, blockerEncoder, blockerMotor);
        blockerPIDController.setSetpoint(goalPoint);
        
        blockerLockingPiston = new DoubleSolenoid(1, 5, 6);
        blockerLockingPiston.set(blockerLockState);
    }
    
    public static Value getBlockerLockState() {
        return blockerLockState;
    }
    public static void setBlockerState(Value value) {
        blockerLockState = value;
        timeToTurnOffBlockerLockingPiston = System.currentTimeMillis() + MILLISECONDS_TO_BLOCK_OR_UNBLOCK;
        blockerLockingPiston.set(blockerLockState);
    }
    
    public static double getGoalPoint() {
        return goalPoint;
    }
    public static void setGoalPoint(double value) {
        goalPoint = value;
        blockerPIDController.setSetpoint(goalPoint);
    }
    public static boolean isAtTarget() {
        return blockerPIDController.onTarget();
    }
    
    public static void alwaysRun() {
        if(System.currentTimeMillis() > timeToTurnOffBlockerLockingPiston) {
            timeToTurnOffBlockerLockingPiston = Long.MAX_VALUE;
            setBlockerState(BLOCKER_LOCK_OFF);
        }
    }
    public static void parameterRefresh() {
    }
}
