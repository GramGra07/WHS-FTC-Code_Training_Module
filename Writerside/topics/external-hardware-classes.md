# External Hardware Classes

### What is an external hardware class?

An external hardware class is a very easy way to abstract your code to make your code much more concise and follow a very organized "flow"

Some of the benefits include having one instance of everything. In this case, you don't have to initialize every single motor in every single auto or teleOp you create, they will all be created for you.

### Why use it?

It allows you to not repeat yourself when coding. Often young coders have every single motor or servo initialized in every single program when that is not entirely necessary. This in general cleans up your code and makes it much easier to read.

### Where do I start?

There is a handy example by FTC [here](https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/ConceptExternalHardwareClass.java)

* Start with creating a new class, probably called HardwareConfig, or something of that sort.&#x20;
* Then define all of your motors, servos, and variables you normally use.
* Make a function called "initRobot" or something of that sort. That will allow you to have a good function. This should take parameters such as an opMode, HardwareMap and maybe an auto (boolean) so you can initialize things differently in auto versus teleOp.
* Make a function that will handle all teleOp "logic". This is handy because you will only need to call one function during your teleOp code.

For instance, this is an example of my code: **NOTE: This will NOT work on your machine just by itself, you will need to replace almost everything with your own code**

Use this code in order to get an idea of what you would like to do with your external hardware class.

```java
package org.firstinspires.ftc.teamcode.opModes;

import android.os.Environment;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.UtilClass.FileWriterFTC;
import org.firstinspires.ftc.teamcode.UtilClass.varConfigurations.LoopTime;
import org.firstinspires.ftc.teamcode.UtilClass.varConfigurations.varConfig;
import org.firstinspires.ftc.teamcode.extensions.BlinkExtensions;
import org.firstinspires.ftc.teamcode.extensions.PoseExtensions;
import org.firstinspires.ftc.teamcode.extensions.SensorExtensions;
import org.firstinspires.ftc.teamcode.humanInput.Drivers;
import org.firstinspires.ftc.teamcode.humanInput.Operator;
import org.firstinspires.ftc.teamcode.rr.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HardwareConfig {
    private LinearOpMode myOpMode;
    private Telemetry telemetry;

    private DriveSubsystem driveSubsystem;
    private ClawSubsystem clawSubsystem;
    private EndgameSubsystem endgameSubsystem;
    private ExtendoSubsystem extendoSubsystem;
    private LocalizationSubsystem localizationSubsystem;

    private RevBlinkinLedDriver lights;
    private AnalogInput potentiometer;
    private VoltageSensor vSensor;
    private MecanumDrive drive;
    private FileWriter fileWriter;
    private boolean once;
    private List<LynxModule> allHubs;

    public HardwareConfig(LinearOpMode opMode, HardwareMap ahwMap, boolean auto) {
        myOpMode = opMode;
        initRobot(ahwMap, auto);
    }

    public void initRobot(HardwareMap ahwMap, boolean auto) {
        vSensor = SensorExtensions.initVSensor(ahwMap, "Expansion Hub 2");
        lights = SensorExtensions.initLights(ahwMap, "blinkin");
        potentiometer = SensorExtensions.initPotent(ahwMap, "potent");
        driveSubsystem = new DriveSubsystem(ahwMap);
        clawSubsystem = new ClawSubsystem(ahwMap);
        endgameSubsystem = new EndgameSubsystem(ahwMap);
        extendoSubsystem = new ExtendoSubsystem(ahwMap);
        localizationSubsystem = new LocalizationSubsystem(ahwMap);

        drive = driveSubsystem.getDrive();

        once = false;
        
        telemetry.addData("Color", lights.currentColor());
        telemetry.addData("Version", CURRENT_VERSION);
        telemetry.addData("Voltage", "%.2f", vSensor.currentVoltage());
        if (vSensor.lowVoltage()) {
            telemetry.addData("lowBattery", "true");
        }
        if (!auto) {
            telemetry.update();
        }
    }

    public void doBulk() {
        driveSubsystem.driveByGamepads(Drivers.fieldCentric, myOpMode);
        driveSubsystem.update(avoidanceSubsystem);
        endgameSubsystem.update();
        clawSubsystem.update();
        extendoSubsystem.update();
        localizationSubsystem.relocalize(drive);
        buildTelemetry();
    }

    private void buildTelemetry() {
        telemetry.addData("Voltage", "%.1f", vSensor.currentVoltage());
        if (vSensor.lowVoltage()) {
            telemetry.addData("", "We have a low battery");
        }
        telemetry.addData("Pose: ", PoseExtensions.toPoint(drive.getPose()).toString());
        telemetry.addData("potentiometer", "%.1f", potentiometer.potentAngle());
        driveSubsystem.telemetry(telemetry);
        extendoSubsystem.telemetry(telemetry);
        teleSpace();
        telemetry.addData("Color", lights.currentColor());
        teleSpace();
        telemetry.addData("Version", CURRENT_VERSION);
        localizationSubsystem.telemetry(telemetry);
        telemetry.update();
        drawPackets();
    }
}
```

### How do I use it?

* Create an object called "robot" or something else of that sort.
* Make that object a HardwareConfig object so it will initialize correctly.
* Use it all together

**NOTE as with above, this code will not work for you, I would HIGHLY suggest writing it all yourself, even if you struggle, just so you know how it all works together**

```java
package org.firstinspires.ftc.teamcode.opModes.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.opModes.HardwareConfig;

@TeleOp(group = "a")
public class teleOp extends LinearOpMode {
    
    @Override
    public void runOpMode() {
        HardwareConfig robot = new HardwareConfig(this, hardwareMap, false);
        //^ creates our "robot" class with the params of opMode, HardwareMap and auto
        waitForStart();
        while (opModeIsActive()) {
            robot.doBulk(); // main function we defined above in the HardwareConfig
        }
    }
}

```
