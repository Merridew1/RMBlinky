package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.Drivetrain;

/**
 * Drive.
 */

public class Drive extends Command {
    private XboxController controller;
    private Drivetrain drive;

    /**
     * Drive again.
     */

    public Drive(Drivetrain drive, XboxController controller) {
        this.controller = controller;
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        double leftY = (Math.abs(controller.getLeftY()) < .05) ? 0 : controller.getLeftY();
        double rightY = (Math.abs(controller.getRightY()) < .05) ? 0 : controller.getRightY();
        this.drive.setPower(leftY, rightY);

    }
}
