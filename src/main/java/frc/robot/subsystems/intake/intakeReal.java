package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class intakeReal implements IntakeIO {
    VictorSP leftIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.LMOTOR);
    VictorSP rightIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.RMOTOR);



    public intakeReal() {
        rightIntake.setInverted(true);
        leftIntake.addFollower(rightIntake);
    }

    public void setIntakePower(double power) {
        leftIntake.set(power);
    }

    @Override
    public void updateInputsIO(IntakeIOInputs inputs) {};

}

