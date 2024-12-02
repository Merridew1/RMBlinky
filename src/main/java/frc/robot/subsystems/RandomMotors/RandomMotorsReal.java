package frc.robot.subsystems.RandomMotors;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import frc.robot.Constants;

public class RandomMotorsReal implements RandomMotorsIO {
    private final CANSparkMax neo =
        new CANSparkMax(Constants.Motors.RandomMotors.NEO, MotorType.kBrushless);
    private final TalonFX falcon = new TalonFX(Constants.Motors.RandomMotors.FALCON);
    private RelativeEncoder rEncoder = neo.getEncoder();
    private StatusSignal<Double> falconVelocity;

    public RandomMotorsReal() {
        falconVelocity = falcon.getVelocity();
    }

    public double encoder() {
        return neo.get();
    }

    @Override
    public void updateInputsIO(RandomMotorsIOInputs inputs) {
        inputs.falconVelocityIO = getFalconVelocity();
        inputs.neoVortexIO = getNeoVelocity();

    }

    public void runMotor(double power) {
        neo.set(power);
        falcon.set(power);
    }

    public double getNeoVelocity() {
        return rEncoder.getVelocity();
    }

    private double getFalconVelocity() {
        return falconVelocity.refresh().getValue();
    }
}
