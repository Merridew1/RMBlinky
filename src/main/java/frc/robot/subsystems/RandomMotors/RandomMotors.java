package frc.robot.subsystems.RandomMotors;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RandomMotors extends SubsystemBase {
    private RandomMotorsIO io;
    private RandomMotorsIOInputsAutoLogged inputs = new RandomMotorsIOInputsAutoLogged();

    public RandomMotors(RandomMotorsIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("RandomMotors", inputs);

    }

    public void runMotor(double power) {
        io.runMotor(power);
    }

    public Command runMotorCommand(double power) {
        return run(() -> runMotor(power));
    }

    public Command runPositiveCommand() {
        return runMotorCommand(1);
    }
    
}
