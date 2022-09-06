package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class SimpleTeleOp extends CommandOpMode {

    private GamepadEx driverOp;
//    private GamepadEx toolOp;
    private DriveSubsystem drive;
    private DefaultDrive driveCommand;

    @Override
    public void initialize() {
        driverOp = new GamepadEx(gamepad1);
//        toolOp = new GamepadEx(gamepad2);

        drive = new DriveSubsystem(hardwareMap, "left", "right", 4);

        driveCommand = new DefaultDrive(drive, driverOp::getLeftY, driverOp::getRightX);

        register(drive);
        drive.setDefaultCommand(driveCommand);
    }

}