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
        public double rightFrontMotor;
        public double leftFrontMotor;
        public double rightBackMotor;
        public double leftbackMotor;
    }

    /** Updates the set of loggable inputs. */
    public default void updateInputs(DrivetrainIOInputs inputs) {}

    /** Run the motor at the specified voltage. */
    public default void setDriveVoltage(double lvolts, double rvolts) {}


}
