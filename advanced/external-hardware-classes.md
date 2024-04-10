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
    private FtcDashboard dashboard;
    private TelemetryPacket packet;
    private ElapsedTime timer;

    private DriveSubsystem driveSubsystem;
    private ClawSubsystem clawSubsystem;
    private EndgameSubsystem endgameSubsystem;
    private ExtendoSubsystem extendoSubsystem;
    private LocalizationSubsystem localizationSubsystem;
    private AvoidanceSubsystem avoidanceSubsystem;

    private RevBlinkinLedDriver lights;
    private double loops;
    private double LPS;
    private double refreshRate;
    private double rrPS;
    private double currentTime;
    private double pastRefreshRate;
    private double pastSecondLoops;
    private double pastTimeRR;
    private double lastTimeOpen;
    private boolean pastUseLoopTime;
    private DigitalChannel green1, green2, green3, green4, red1, red2, red3, red4;
    private AnalogInput potentiometer;
    private VoltageSensor vSensor;
    private MecanumDrive drive;
    private FileWriter fileWriter;
    private boolean once;
    private int correctedLPS;

    public static final String CURRENT_VERSION = "7.0.0";
    private List<LynxModule> allHubs;

    public HardwareConfig() {}

    public HardwareConfig(LinearOpMode opMode, HardwareMap ahwMap, boolean auto) {
        myOpMode = opMode;
        initRobot(ahwMap, auto);
    }

    public void initRobot(HardwareMap ahwMap, boolean auto) {
        vSensor = SensorExtensions.initVSensor(ahwMap, "Expansion Hub 2");
        lights = SensorExtensions.initLights(ahwMap, "blinkin");
        potentiometer = SensorExtensions.initPotent(ahwMap, "potent");
        green1 = SensorExtensions.initDigiChan(ahwMap, "green1");
        green2 = SensorExtensions.initDigiChan(ahwMap, "green2");
        green3 = SensorExtensions.initDigiChan(ahwMap, "green3");
        green4 = SensorExtensions.initDigiChan(ahwMap, "green4");
        red1 = SensorExtensions.initDigiChan(ahwMap, "red1");
        red2 = SensorExtensions.initDigiChan(ahwMap, "red2");
        red3 = SensorExtensions.initDigiChan(ahwMap, "red3");
        red4 = SensorExtensions.initDigiChan(ahwMap, "red4");
        allHubs = ahwMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
        driveSubsystem = new DriveSubsystem(ahwMap);
        clawSubsystem = new ClawSubsystem(ahwMap);
        endgameSubsystem = new EndgameSubsystem(ahwMap);
        extendoSubsystem = new ExtendoSubsystem(ahwMap);
        localizationSubsystem = new LocalizationSubsystem(ahwMap);
        avoidanceSubsystem = new AvoidanceSubsystem(AvoidanceSubsystem.AvoidanceTypes.PUSH);

        drive = driveSubsystem.getDrive();
        telemetry = new MultipleTelemetry(myOpMode.telemetry, FtcDashboard.getInstance().getTelemetry());
        dashboard = FtcDashboard.getInstance();

        once = false;
        String file = String.format("%s/FIRST/matchlogs/log.txt", Environment.getExternalStorageDirectory().getAbsolutePath());
        try {
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriterFTC.setUpFile(fileWriter);
        timer = new ElapsedTime();
        timer.reset();
        green1.ledIND(red1, true);
        green2.ledIND(red2, true);
        green3.ledIND(red3, true);
        green4.ledIND(red4, true);
        telemetry.addData("Color", lights.currentColor());
        telemetry.addData("Version", CURRENT_VERSION);
        telemetry.addData("Voltage", "%.2f", vSensor.currentVoltage());
        if (vSensor.lowVoltage()) {
            telemetry.addData("lowBattery", "true");
        }
        if (!auto) {
            telemetry.update();
        }
        drawPackets();
    }

    public void doBulk() {
        currentTime = timer.seconds();
        loopTimeCalculations();
        Drivers.bindDriverButtons(myOpMode, driveSubsystem, clawSubsystem, endgameSubsystem);
        Operator.bindOtherButtons(myOpMode, clawSubsystem, extendoSubsystem, driveSubsystem);
        if (varConfig.multipleDrivers) {
            Drivers.switchProfile(myOpMode);
        }
        driveSubsystem.driveByGamepads(Drivers.fieldCentric, myOpMode);
        driveSubsystem.update(avoidanceSubsystem);
        endgameSubsystem.update();
        clawSubsystem.update();
        extendoSubsystem.update();
        avoidanceSubsystem.update(drive);
        localizationSubsystem.relocalize(drive);
        buildTelemetry();
        lynxModules();
        if (currentTime > correctedLPS) {
            loops++;
        }
    }

    private void lynxModules() {
        for (LynxModule hub : allHubs) {
            hub.clearBulkCache();
        }
    }

    private void buildTelemetry() {
        telemetry.addData("Drivers", Drivers.currDriver + " " + Drivers.currOther);
        telemetry.addData("Voltage", "%.1f", vSensor.currentVoltage());
        if (vSensor.lowVoltage()) {
            telemetry.addData("", "We have a low battery");
        }
        telemetry.addData("Pose: ", PoseExtensions.toPoint(drive.getPose()).toString());
        telemetry.addData("potentiometer", "%.1f", potentiometer.potentAngle());
        driveSubsystem.telemetry(telemetry);
        avoidanceSubsystem.telemetry(telemetry);
        extendoSubsystem.telemetry(telemetry);
        teleSpace();
        telemetry.addData("Timer", "%.1f", currentTime);
        telemetry.addData("Loops", "%.1f", loops);
        telemetry.addData("Current LPS", "%.1f", LPS);
        telemetry.addData("Refresh Rate", "%.1f", rrPS);
        teleSpace();
        telemetry.addData("Color", lights.currentColor());
        teleSpace();
        telemetry.addData("Version", CURRENT_VERSION);
        localizationSubsystem.telemetry(telemetry);
        telemetry.update();
        drawPackets();
    }

    private void drawPackets() {
        packet = new TelemetryPacket();
        double rad = avoidanceSubsystem.rad;
        double roboRad = varConfig.robotRadiusAvoidance;
        packet.fieldOverlay()
                .setFill("red")
                .setAlpha(0.3);
        for (AvoidanceSubsystem.Field field : avoidanceSubsystem.fields) {
            packet.fieldOverlay()
                    .fillCircle(field.point.y, field.point.x, rad);
        }
        Vector2d t = drive.getPose().vec();
        Vector2d halfv = t.heading().vec().times(0.5 * roboRad);
        Vector2d p1 = t.plus(halfv);
        double x = p1.getX() + halfv.getX();
        double y = p1.getY() + halfv.getY();
        packet.fieldOverlay()
                .setStrokeWidth(1)
                .setFill("DeepPink")
                .setAlpha(1.0)
                .strokeCircle(t.getX(), t.getY(), roboRad).strokeLine(p1.getX(), p1.getY(), x, y);
        dashboard.sendTelemetryPacket(packet);
    }

    private void teleSpace() {
        telemetry.addLine(" ");
    }

    private void loopTimeCalculations() {
        if (pastSecondLoops != LoopTime.loopInterval) {
            timer.reset();
            loops = 0.0;
            refreshRate = 0.0;
            pastSecondLoops = LoopTime.loopInterval;
        }
        if (LoopTime.useLoopTime != pastUseLoopTime) {
            timer.reset();
            loops = 0.0;
            refreshRate = 0.0;
            pastUseLoopTime = LoopTime.useLoopTime;
        }
        LPS = loops / (currentTime - correctedLPS);
        if (refreshRate != pastRefreshRate) {
            rrPS = currentTime - pastTimeRR;
            pastRefreshRate = refreshRate;
            pastTimeRR = currentTime;
        }

        if (LoopTime.useLoopTime && loops % LoopTime.loopInterval == 0.0) {
            refreshRate++;
            drive.updatePoseEstimate();
        }
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
