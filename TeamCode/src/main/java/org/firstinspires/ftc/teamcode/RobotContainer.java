package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.subsystems.BufferSubsystem;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotContainer {
    private HardwareMap hardwareMap;
    private final BufferSubsystem buffer;

    public RobotContainer(){
        this.buffer = new BufferSubsystem(hardwareMap, "buffer");
    }

    private void configureButtonBidings(){

    }
}
