package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.commands.Shoot;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotContainer {
    private HardwareMap hardwareMap;
    private final ShooterSubsystem shooter = new ShooterSubsystem(hardwareMap, "shooter");

    public RobotContainer(){
        CommandScheduler.getInstance().setDefaultCommand((Subsystem) shooter, new Shoot(shooter));
    }

    private void configureButtonBidings(){

    }
}
