package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Shooter;

public class FireAndReloadWithLimitSwitch extends Command {
    public static final FireAndReloadWithLimitSwitch instance;
    static {
        instance = new FireAndReloadWithLimitSwitch();
        Commands.registerCommand(instance);
    }
    private long timeStarted = 0;
    void internalStart() {
        Shooter.instance.setPIDEnabled(false);
        timeStarted = System.currentTimeMillis();
    }
    void internalRun() {
        long timeSinceStart = System.currentTimeMillis() - timeStarted;
        boolean switchIsPressed = Shooter.instance.isLimitSwitchPressed();
        if(timeSinceStart <= 1500) {
            Shooter.instance.setMotorPower(-1.0);
        } else if(!switchIsPressed) {
            Shooter.instance.setMotorPower(-0.1);
        } else if(switchIsPressed) {
            Shooter.instance.setMotorPower(0.0);
            this.state = FINISHING;
        }
    }
    void internalNotRun() {
    }
    void internalFinish() {
    }
}