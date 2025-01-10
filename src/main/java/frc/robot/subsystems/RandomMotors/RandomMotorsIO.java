package frc.robot.subsystems.RandomMotors;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.units.measure.AngularVelocity;

public interface RandomMotorsIO {

    @AutoLog
    public static class RandomMotorsIOInputs {
        public AngularVelocity falconMotorIO;
        public double neoVortexIO;
        public double neovelocityIO;
        public AngularVelocity falconVelocityIO;

    }

    public void updateInputsIO(RandomMotorsIOInputs inputs);

    public void runMotorIO(double voltage);

}
