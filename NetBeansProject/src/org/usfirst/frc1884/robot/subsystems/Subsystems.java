package org.usfirst.frc1884.robot.subsystems;

import java.util.Vector;
import org.usfirst.frc1884.util.parameters.ParameterFile;

public class Subsystems {
    private static Vector subsystems = new Vector();
    public static void registerSubsystem(Subsystem s) {
        subsystems.addElement(s);
    }
    private static long nextTimeToParameterUpdate = 0;
    public static void subsystemAlwaysRuns() {
        parameterRefresh();
        for(int i = 0; i < subsystems.size(); i++) {
            Subsystem s = (Subsystem) subsystems.elementAt(i);
            s.alwaysRun();
        }
    }
    public static void parameterRefresh() {
        if(System.currentTimeMillis() > nextTimeToParameterUpdate) {
            ParameterFile.readFile();
            nextTimeToParameterUpdate = System.currentTimeMillis() + 1000;
            for(int i = 0; i < subsystems.size(); i++) {
                Subsystem s = (Subsystem) subsystems.elementAt(i);
                s.parameterRefresh();
            }
        }
    }
    
    // Keep this at the bottom
    static {
        DriveTrain.instance.parameterRefresh();
        Intake.instance.parameterRefresh();
        Shooter.instance.parameterRefresh();
    }
}