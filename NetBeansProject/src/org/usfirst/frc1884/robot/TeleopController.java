package org.usfirst.frc1884.robot;

import org.usfirst.frc1884.robot.commands.LowerBlocker;
import org.usfirst.frc1884.robot.commands.RaiseBlocker;
import org.usfirst.frc1884.robot.oi.OI;

public class TeleopController {
    public static void init() {
        
    }
    public static void periodic() {
        if(OI.isBooleanChanged(OI.BLOCKER_EXTEND) && OI.isBooleanTrue(OI.BLOCKER_EXTEND)) {
            RaiseBlocker.start();
        }
        if(OI.isBooleanChanged(OI.BLOCKER_EXTEND) && !OI.isBooleanTrue(OI.BLOCKER_EXTEND)) {
            LowerBlocker.start();
        }
        
        // Execute every command!!!
        RaiseBlocker.execute();
        LowerBlocker.execute();
    }
}