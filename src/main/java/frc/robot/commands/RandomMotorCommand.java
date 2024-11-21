package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RandomMotors.RandomMotors;

public class RandomMotorCommand extends Command {
    private RandomMotors randMot;

    public RandomMotorCommand(RandomMotors randMot) {
        this.randMot = randMot;
        addRequirements(randMot);
    }

    @Override
    public void execute() {
        randMot.runMotor(1);
    }
}
