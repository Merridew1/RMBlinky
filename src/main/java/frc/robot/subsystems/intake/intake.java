package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
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


    public Command runMotorCommand(int power) {
        return run(() -> setIntakePower(power)); 
    }

    

    public Command intakeCommand() {
        return runMotorCommand(1); // Borrows runMotorCommand from above at 1
    }
    public Command outakCommand() {
        return runMotorCommand(-1); // Borrows runMotorCommand from above at -1
    }


}
