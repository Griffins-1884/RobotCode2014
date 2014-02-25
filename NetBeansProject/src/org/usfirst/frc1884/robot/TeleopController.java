package org.usfirst.frc1884.robot;

import org.usfirst.frc1884.robot.commands.LowerBlocker;
import org.usfirst.frc1884.robot.commands.RaiseBlocker;
import org.usfirst.frc1884.robot.oi.OI;

public class TeleopController {
    public static void init() {
        
    }
    public static void periodic() {
        if(OI.isBooleanTrue(OI.BLOCKER_EXTEND)) {
            LowerBlocker.finish();
            RaiseBlocker.start();
        } else {
            RaiseBlocker.finish();
            LowerBlocker.start();
        }
        
        // Execute every command!!!
        RaiseBlocker.execute();
        LowerBlocker.execute();
    }
}