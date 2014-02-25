package org.usfirst.frc1884.util.pid;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;

public class PIDEncoderTalonController extends PIDController {
    public PIDEncoderTalonController(double p, double i, double d, Encoder input, Talon output) {
        super(p, i, d, new PIDEncoderSource(input), new PIDTalonOutput(output));
        this.setOutputRange(-1, 1);
        this.enable();
    }
}