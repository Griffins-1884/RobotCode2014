package org.usfirst.frc1884.robot.subsystems;

import java.util.Vector;

public class Subsystems {
    private static Vector subsystems = new Vector();
    public static void registerSubsystem(Subsystem s) {
        subsystems.addElement(s);
    }
    public static void subsystemAlwaysRuns() {
        for(int i = 0; i < subsystems.size(); i++) {
            Subsystem s = (Subsystem) subsystems.elementAt(i);
            s.alwaysRun();
        }
    }
}