package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import org.usfirst.frc1884.robot.commands.FireAndReload;
import org.usfirst.frc1884.util.parameters.DoubleParameter;

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
        chooChooPIDController = new PIDEncoderTalonController(0.1, 0.0, 0.2, chooChooEncoder, chooChooMotor);
        chooChooPIDController.setAbsoluteTolerance(0.2);
        chooChooPIDController.setSetpoint(goalPoint);
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
    public double getEncoderValue() {
        return chooChooEncoder.getDistance();
    }
    public boolean isAtTarget() {
        return chooChooPIDController.onTarget();
    }
    public void resetEncoder() {
        this.setGoalPoint(0.0);
        chooChooEncoder.reset();
    }
    
    public void alwaysRun() {
    }
    private DoubleParameter p = DoubleParameter.get("Shooter/P"),
                            i = DoubleParameter.get("Shooter/I"),
                            d = DoubleParameter.get("Shooter/D"); 
    public void parameterRefresh() {
        chooChooPIDController.setPID(p.getValue(), i.getValue(), d.getValue());
    }
}