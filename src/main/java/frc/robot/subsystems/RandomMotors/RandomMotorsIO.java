package frc.robot.subsystems.RandomMotors;

import org.littletonrobotics.junction.AutoLog;
public interface RandomMotorsIO {


    @AutoLog
    public static class RandomMotorsIOInputs {
        public double falconMotorIO;
        public double neoVortexIO;
        public double neovelocityIO;
        public double falconVelocityIO;

    }

    public default void updateInputsIO(RandomMotorsIOInputs inputs) {}

    public default void runMotorIO(double voltage) {}
}