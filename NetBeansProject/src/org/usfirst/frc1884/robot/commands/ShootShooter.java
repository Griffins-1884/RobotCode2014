package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Shooter;

public class ShootShooter extends Command {
    public static final ShootShooter instance;
    static {
        instance = new ShootShooter();
        Commands.registerCommand(instance);
    }
    void internalStart() {
//        Shooter.instance.setGoalPoint(1.0);
        Shooter.instance.setMotorPower(1.0);
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
        System.out.println("finishing fire " + Shooter.instance.getEncoderDistance());
    }
}