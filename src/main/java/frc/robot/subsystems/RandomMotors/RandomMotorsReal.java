package frc.robot.subsystems.RandomMotors;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.units.measure.AngularVelocity;
import frc.robot.Constants;

public class RandomMotorsReal implements RandomMotorsIO {
    private final SparkMax neo = new SparkMax(Constants.Motors.RandomMotors.NEO, MotorType.kBrushless);
    private final TalonFX falcon = new TalonFX(Constants.Motors.RandomMotors.FALCON);
    private RelativeEncoder rEncoder = neo.getEncoder();
    private StatusSignal<AngularVelocity> falconVelocity;

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

    @Override
    public void runMotorIO(double power) {
        neo.set(power);
        falcon.set(power);
    }

    public double getNeoVelocity() {
        return rEncoder.getVelocity();
    }

    private AngularVelocity getFalconVelocity() {
        return falconVelocity.refresh().getValue();
    }
}
