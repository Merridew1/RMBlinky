package frc.robot.subsystems.Intake2;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake2 extends SubsystemBase {
    private IntakeIO2 io;
    private IntakeIO2InputsAutoLogged inputs = new IntakeIO2InputsAutoLogged();

    public Intake2(IntakeIO2 io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputsIO(inputs);
        Logger.processInputs("Intake", inputs);

    }

    public void setIntakePower(double power) {
        Logger.recordOutput("intake/power", power);
        io.setIntakePowerIO(power);
    }

    public Command intakeCommand(double power) {
        return Commands.startEnd(() -> {
            setIntakePower(power);
        }, () -> {
            setIntakePower(0);
        }, this);
    }

}
