package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotContainer {
    private HardwareMap hardwareMap;
    private final IntakeSubsystem intake;

    public RobotContainer(){
        this.intake = new IntakeSubsystem(hardwareMap, "intake");
    }

    private void configureButtonBidings(){

    }
}
