package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.*;

import org.usfirst.frc1884.util.pid.PIDEncoderTalonController;

public class Shooter {
    private static Talon chooChooMotor;
    private static Encoder chooChooEncoder;
    private static PIDController chooChooPIDController;
    
    private static double goalPoint = 0.0;
    
    static {
        chooChooMotor = new Talon(1, 5);
        chooChooEncoder = new Encoder(1, 7, 1, 8);
        chooChooPIDController = new PIDEncoderTalonController(1.0, 0.0, 0.0, chooChooEncoder, chooChooMotor);
        chooChooPIDController.setContinuous(true);
        chooChooPIDController.setAbsoluteTolerance(0.2);
        chooChooPIDController.setSetpoint(goalPoint);
    }
    
    public static double getGoalPoint() {
        return goalPoint;
    }
    public static void setGoalPoint(double value) {
        goalPoint = value;
        chooChooPIDController.setSetpoint(goalPoint);
    }
    public static boolean isAtTarget() {
        return chooChooPIDController.onTarget();
    }
    
    public static void alwaysRun() {
    }
    public static void parameterRefresh() {
    }
}
