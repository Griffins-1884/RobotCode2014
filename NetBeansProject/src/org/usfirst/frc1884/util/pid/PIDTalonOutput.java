package org.usfirst.frc1884.util.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;

public class PIDTalonOutput implements PIDOutput {
    private Talon output;
    
    public PIDTalonOutput(Talon output) {
        this.output = output;
    }

    public void pidWrite(double d) {
        output.set(d);
    }
}