package frc.robot.subsystems.RandomMotors;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;

public class RandomMotorsReal implements RandomMotorsIO {
    private final CANSparkMax neoVortex =
        new CANSparkMax(Constants.Motors.RandomMotors.NEOVORTEX, MotorType.kBrushless);
    private final TalonFX Falcon = new TalonFX(Constants.Motors.RandomMotors.FALCON);

    @Override
    public void updateInputs(RandomMotorsIOInputs inputs) {}

    public void runMotor(double power) {
        neoVortex.set(power);
        Falcon.set(power);
    }

}
