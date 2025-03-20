# Coding

The java coding language that we use is not incredibly hard to learn once you figure it all out. It follows all the coding fundamentals you may already know.

#### **IMPORTANT** when editing your code, only edit it in the **Team Code** section. **DO NOT** edit the FTC robot controller sample code

* You will have to copy and paste the files from the external samples
* It is very important that you only modify the TEAMCODE directory, any other directory can corrupt your project very easily and I see it happen and break Control Hubs a LOT

### There is a lot of excellent info and sample opModes [here](https://github.com/FIRST-Tech-Challenge/FtcRobotController/tree/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples)

#### Getting started 

* Configuration of devices

`DcMotor name = hardwareMap.get(DcMotor.class, "name");`

`Servo name = hardwareMap.get(Servo.class, "name");`

The second name is the one you will use in the configuration guide in your driver station. The first name is the one you will use to set powers and other functions.

#### Setting up your files

Refer to the blank examples. These both have the proper setup and code to get started coding both of these modes. I will get into more detail into what everything means in TeleOp and auto.
