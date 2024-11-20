package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.AutoLog;

public interface intakeIO {

    @AutoLog
    public static class intakeIOInputs {
        public double rightMotor;
        public double leftMotor;
    }

    /** Updates the set of loggable inputs. */

    public default void intakePower(double lvolts, double rvolts) {}

}

