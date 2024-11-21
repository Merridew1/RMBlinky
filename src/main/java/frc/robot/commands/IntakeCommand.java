package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Intake.Intake;

public class IntakeCommand extends Command {
    private CommandXboxController controller;
    private Intake intake;

    public IntakeCommand(Intake intake, CommandXboxController controller) {
        this.controller = controller;
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.setIntakeVoltage(1);
        controller.leftTrigger().whileTrue(new InstantCommand(() -> intake.setIntakeVoltage(-1)));
    }
}
