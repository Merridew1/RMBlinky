package frc.robot.subsystems.RandomMotors;

import org.littletonrobotics.junction.Logger;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RandomMotors extends SubsystemBase {
    private RandomMotorsIO io;
    private RandomMotorsIOInputsAutoLogged inputs = new RandomMotorsIOInputsAutoLogged();

    public RandomMotors(RandomMotorsIO io) {
        this.io = io;
        io.updateInputsIO(inputs);
    }

    @Override
    public void periodic() {
        io.updateInputsIO(inputs);
        Logger.processInputs("RandomMotors", inputs);

    }

    public void runMotor(double power) {
        io.runMotorIO(power);
    }

    public Command runMotorCommand(double power) {
        return runEnd(() -> {
            runMotor(power);
        }, () -> {
            runMotor(0);
        });
    }
}
