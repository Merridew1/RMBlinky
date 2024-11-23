package frc.robot.subsystems.RandomMotors;

import org.littletonrobotics.junction.AutoLog;
public interface RandomMotorsIO {


    @AutoLog
    public static class RandomMotorsIOInputs {
        public double falconMotor;
        public double neoVortex;
        public double neovelocity;
        public double falconVelocity;

    }

    public default void updateInputs(RandomMotorsIOInputs inputs) {}

    public default void runMotor(double voltage) {}
}