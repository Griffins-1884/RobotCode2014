package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Shooter;

public class ReloadShooter extends Command {
    public static final ReloadShooter instance;
    static {
        instance = new ReloadShooter();
        Commands.registerCommand(instance);
    }
    void internalStart() {
//        Shooter.instance.setGoalPoint(1.0);
        Shooter.instance.setMotorPower(-1.0);
    }
    void internalRun() {
//        if(Shooter.instance.isAtTarget()) {
//            state = FINISHING;
//        }
    }
    void internalNotRun() {
    }
    void internalFinish() {
        Shooter.instance.setMotorPower(0.0);
        System.out.println("finishing reload " + Shooter.instance.getEncoderDistance());
    }
}