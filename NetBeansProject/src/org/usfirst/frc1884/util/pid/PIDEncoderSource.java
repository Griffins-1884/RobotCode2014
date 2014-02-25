package org.usfirst.frc1884.util.pid;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;

public class PIDEncoderSource implements PIDSource {
    private Encoder input;
    
    public PIDEncoderSource(Encoder input) {
        this.input = input;
    }
    
    public double pidGet() {
        return input.getDistance();
    }
}