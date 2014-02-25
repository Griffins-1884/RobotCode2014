/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc1884.util.pid.PIDEncoderTalonController;

/**
 *
 * @author jwang
 */
public class Shooter extends PIDSubsystem {

    private static Talon chuchuMotor;
    private static Encoder chuchuEncoder;
    private static PIDController chuchuPIDController;
    
    private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    private static double goalPoint = 0.0;

    // Initialize your subsystem here
    public Shooter() {
        super("Shooter", Kp, Ki, Kd);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(true);
        getPIDController().setOutputRange(-1.0, 1.0);
        chuchuPIDController = new PIDEncoderTalonController(1.0, 0.0, 0.0, chuchuEncoder, chuchuMotor);
        enable();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public static void setGoalPoint(double value) {
        goalPoint = value;
        chuchuPIDController.setSetpoint(goalPoint);
    }
    public static boolean isAtTarget() {
        return chuchuPIDController.onTarget();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return chuchuEncoder.pidGet();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        chuchuMotor.pidWrite(output);
    }
}
