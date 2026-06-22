(ehc)=
# External Hardware Classes

## What is an external hardware class?

An external hardware class is a very easy way to abstract your code to make your code much more concise and follow a very organized "flow"

Some of the benefits include having one instance of everything. In this case, you don't have to initialize every single motor in every single auto or teleOp you create, they will all be created for you.

## Why use it?

It allows you to not repeat yourself when coding. Often young coders have every single motor or servo initialized in every single program when that is not entirely necessary. This in general cleans up your code and makes it much easier to read.

## Where do I start?

There is a handy example by FTC [here](https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/externalhardware/ConceptExternalHardwareClass.java)

* Start with creating a new class, probably called HardwareConfig, or something of that sort.
* Then define all of your motors, servos, and variables you normally use.
* Make a function called "initRobot" or something of that sort. That will allow you to have a good function. This should take parameters such as an opMode, HardwareMap and maybe an auto (boolean) so you can initialize things differently in auto versus teleOp.
* Make a function that will handle all teleOp "logic". This is handy because you will only need to call one function during your teleOp code.

For instance, this is an example of my code: **NOTE: This will NOT work on your machine just by itself, you will need to replace almost everything with your own code**

Use this code in order to get an idea of what you would like to do with your external hardware class.

```java
package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class HardwareConfig {
    private LinearOpMode myOpMode;
    private Telemetry telemetry;

	// all motors

    public HardwareConfig(LinearOpMode opMode, HardwareMap ahwMap, boolean auto) {
        myOpMode = opMode;
		telemetry = myOpMode.telemetry;
        initRobot(ahwMap, auto);
    }

    public void initRobot(HardwareMap ahwMap, boolean auto) {
		// all robot initializations
        if (!auto) { // different things may be initialized during auto
            telemetry.update();
        }
    }

    public void doBulk() {
		// drive and the other "mainLoop()" operations
        buildTelemetry();
    }

    private void buildTelemetry() {
		// all of the telemetry!
        telemetry.update();
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
