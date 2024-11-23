package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class intakeReal implements IntakeIO {
    VictorSP leftIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.LMOTOR);
    VictorSP rightIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.RMOTOR);


    public void setIntakePower(double power) {
        rightIntake.setInverted(true);
        leftIntake.set(power);
        rightIntake.set(power);
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {};

}

