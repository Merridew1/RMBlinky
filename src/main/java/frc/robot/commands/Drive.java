package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drive.Drivetrain;

/**
 * Drive.
 */

public class Drive extends Command {
    private CommandXboxController controller;
    private Drivetrain drive;

    /**
     * Drive again.
     */

    public Drive(Drivetrain drive, CommandXboxController controller) {
        this.controller = controller;
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        double leftY = (Math.abs(controller.getLeftY()) < .05) ? 0 : controller.getLeftY();
        double rightY = (Math.abs(controller.getRightY()) < .05) ? 0 : controller.getRightY();
        drive.setPower(leftY, rightY);

    }
}
