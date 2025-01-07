package frc.robot.subsystems.intake2;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {

    @AutoLog
    public static class IntakeIOInputs {
        public double rightMotorVelocityIO;
        public double leftMotorVelocityIO;
    }

    /** Updates the set of loggable inputs. */
    public void updateInputsIO(IntakeIOInputs inputs);

    public void setIntakePowerIO(double power);

}

