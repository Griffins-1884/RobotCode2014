package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Shooter;

public class FireAndReload extends Command {
    public static final FireAndReload instance;
    static {
        instance = new FireAndReload();
        Commands.registerCommand(instance);
    }
    void internalStart() {
        Shooter.instance.setGoalPoint(Shooter.instance.getGoalPoint() - 360.0);
    }
    void internalRun() {
        System.out.println("Encoder: " + Shooter.instance.getEncoderValue());
        System.out.println("Goal Point" + Shooter.instance.getGoalPoint());
        if(Shooter.instance.isAtTarget()) {
            state = FINISHING;
        }
    }
    void internalNotRun() {
    }
    void internalFinish() {
    }
}