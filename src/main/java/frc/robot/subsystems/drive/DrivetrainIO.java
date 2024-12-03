package frc.robot.subsystems.drive;

import org.littletonrobotics.junction.AutoLog;

/**
 * DrivetrainIO interface
 */
public interface DrivetrainIO {
    /**
     * Drivetrain IO
     */
    @AutoLog
    public static class DrivetrainIOInputs {
        public double rightFrontMotorPWMValueIO;
        public double leftFrontMotorPWMValueIO;
        public double rightBackMotorPWMValueIO;
        public double leftbackMotorPWMIOValue;
    }

    /** Updates the set of loggable inputs. */
    public void updateInputsIO(DrivetrainIOInputs inputs);

    /** Run the motor at the specified voltage. */
    public void setDrivePowerIO(double lvolts, double rvolts);


}
