package frc.robot.subsystems.RandomMotors;

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
    }

    public void runMotor(double power) {
        io.runMotor(power);
    }


}
