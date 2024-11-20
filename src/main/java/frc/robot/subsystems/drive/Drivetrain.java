package frc.robot.subsystems.drive;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * Drivetrain subsystem.
 */

public class Drivetrain extends SubsystemBase {
    private DrivetrainIO io;
    private DrivetrainIOInputsAutoLogged inputs = new DrivetrainIOInputsAutoLogged();
    private CommandXboxController driver;

    /**
     * Create Wrist Intake Subsystem
     */
    public Drivetrain(DrivetrainIO iop, CommandXboxController driverp) {
        this.io = iop;
        io.updateInputs(inputs);

    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Drivetrain", inputs);

        double driverY = driver.getLeftY();
        double driverX = driver.getRightY();
    }
}

