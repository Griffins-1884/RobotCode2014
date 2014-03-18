package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.*;

import org.usfirst.frc1884.util.pid.PIDEncoderTalonController;

public class Shooter extends Subsystem {
    public static final Shooter instance;
    static {
        instance = new Shooter();
        Subsystems.registerSubsystem(instance);
    }
    
    private Talon chooChooMotor;
    private Encoder chooChooEncoder;
    private PIDController chooChooPIDController;
    
    private double goalPoint = 0.0;
    
    private Shooter() {
        chooChooMotor = new Talon(1, 5);
        chooChooEncoder = new Encoder(1, 7, 1, 8);
        chooChooEncoder.setDistancePerPulse(360.0/250.0);
        chooChooEncoder.start();
//        chooChooPIDController = new PIDEncoderTalonController(1.0, 0.0, 0.0, chooChooEncoder, chooChooMotor);
//        chooChooPIDController.setContinuous(true);
//        chooChooPIDController.setAbsoluteTolerance(0.2);
//        chooChooPIDController.setSetpoint(goalPoint);
    }
    
    public double getGoalPoint() {
        return goalPoint;
    }
    public void setGoalPoint(double value) {
        goalPoint = value;
        chooChooPIDController.setSetpoint(goalPoint);
    }
    public void setMotorPower(double value) {
        chooChooMotor.set(value);
    }
    public double getEncoderDistance() {
        return chooChooEncoder.getDistance();
    }
    public boolean isAtTarget() {
        return chooChooPIDController.onTarget();
    }
    
    public void alwaysRun() {
    }
    public void parameterRefresh() {
    }
    public static class ShooterPIDController extends PIDEncoderTalonController {
        public ShooterPIDController(double p, double i, double d, Encoder input, Talon output) {
            super(p, i, d, input, output);
        }
        public double calculateError(double target, double position) {
            double result = target - position;
            if(result <= -5.0) {
                result += 360.0;
            }
            return result;
        }
    }
}