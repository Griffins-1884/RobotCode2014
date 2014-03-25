package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.TeleopController;
import org.usfirst.frc1884.robot.subsystems.Shooter;

public class FireAndReload extends Command {
    public static final FireAndReload instance;
    static {
        instance = new FireAndReload();
        Commands.registerCommand(instance);
    }
    private long timeStarted = 0;
    void internalStart() {
        Shooter.instance.setPIDEnabled(true);
        Shooter.instance.setGoalPoint(Shooter.instance.getGoalPoint() - 360.0);
        timeStarted = System.currentTimeMillis();
    }
    void internalRun() {
        if(Shooter.instance.isAtTarget()) {
            state = FINISHING;
        }
        
        long timeSinceStart = System.currentTimeMillis() - timeStarted;
        
        if(timeSinceStart >= 3000) { // TODO calibrate this time value
            System.out.println("Switching to limit switch");
            TeleopController.encoderBroken = true;
            this.finish();
            FireAndReloadWithLimitSwitch.instance.start();
        }
    }
    void internalNotRun() {
    }
    void internalFinish() {
    }
}