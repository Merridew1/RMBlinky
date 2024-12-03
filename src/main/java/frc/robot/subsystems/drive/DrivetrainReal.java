package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants;

/**
 * DrivetrainReal
 */
public class DrivetrainReal implements DrivetrainIO {

    private final VictorSP FLMotor = new VictorSP(Constants.Motors.DriveTrainMotors.FLMOTOR);
    private final VictorSP FRMotor = new VictorSP(Constants.Motors.DriveTrainMotors.FRMOTOR);
    private final VictorSP BLMotor = new VictorSP(Constants.Motors.DriveTrainMotors.BLMOTOR);
    private final VictorSP BRMotor = new VictorSP(Constants.Motors.DriveTrainMotors.BRMOTOR);


    /**
     * Drivetrain Real
     */
    public DrivetrainReal() {
        BLMotor.addFollower(FLMotor);
        BRMotor.addFollower(FRMotor);

        BLMotor.setInverted(true);
    }

    @Override
    public void updateInputsIO(DrivetrainIOInputs inputs) {
        inputs.leftFrontMotorPWMValueIO = FLMotor.get();
        inputs.leftbackMotorPWMIOValue = BLMotor.get();
        inputs.rightFrontMotorPWMValueIO = FRMotor.get();
        inputs.rightBackMotorPWMValueIO = BRMotor.get();
    }

    /**
     * Drive Voltage
     */
    @Override
    public void setDrivePowerIO(double lvolts, double rvolts) {
        FLMotor.set(lvolts);
        FRMotor.set(rvolts);
    }

}
