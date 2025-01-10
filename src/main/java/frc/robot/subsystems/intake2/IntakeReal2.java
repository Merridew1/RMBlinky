package frc.robot.subsystems.Intake2;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeReal2 implements IntakeIO2 {
    VictorSP leftIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.LMOTOR);
    VictorSP rightIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.RMOTOR);

    public IntakeReal2() {
        rightIntake.setInverted(true);
        leftIntake.addFollower(rightIntake);
    }

    @Override
    public void setIntakePowerIO(double power) {
        leftIntake.set(power);
    }

    @Override
    public void updateInputsIO(IntakeIO2Inputs inputs) {
    };

}
