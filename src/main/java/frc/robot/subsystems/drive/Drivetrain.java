package frc.robot.subsystems.drive;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * Drivetrain subsystem.
 */

public class Drivetrain extends SubsystemBase {
    private DrivetrainIO io;
    private DrivetrainIOInputsAutoLogged inputs = new DrivetrainIOInputsAutoLogged();

    /**
     * Create Wrist Intake Subsystem
     */
    public Drivetrain(DrivetrainIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputsIO(inputs);
        Logger.processInputs("Drivetrain", inputs);
    }

    public void setPower(double lPower, double rPower) {
        io.setDrivePowerIO(lPower, rPower);
    }

    public Command driveCommand(CommandXboxController controller) {
        return run(() -> {
            setPower(controller.getLeftY(), controller.getRightY());
        });
    }

}
