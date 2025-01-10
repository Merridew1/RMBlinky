package frc.robot.subsystems.Intake2;

import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO2 {

    @AutoLog
    public static class IntakeIO2Inputs {
        public double rightMotorVelocityIO;
        public double leftMotorVelocityIO;
    }

    /** Updates the set of loggable inputs. */
    public void updateInputsIO(IntakeIO2Inputs inputs);

    public void setIntakePowerIO(double power);

}
