package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private IntakeIO io;
    private IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();

    public Intake(IntakeIO io) {
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
