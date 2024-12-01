package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {

    @AutoLog
    public static class IntakeIOInputs {
        public double rightMotorVelocityIO;
        public double leftMotorVelocityIO;
    }

    /** Updates the set of loggable inputs. */
    public default void updateInputsIO(IntakeIOInputs inputs) {}

    public default void setIntakePowerIO(double power) {}

}

