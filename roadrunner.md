# RoadRunner

Road Runner is a very convenient, easy to use software to make your robot follow a path you create.

[Learn Road Runner](https://learnroadrunner.com/#frequently-asked-questions) is one of the best sites I have found to learn how to use Road Runner. It walks through all of the steps from start to finish but I have found some specific things that I have found to be slightly different for my robot, using Rev Ultra-planetary Motors with a gearboxes.

I went through all of Learn Road Runner in around two hours after I was able to make my Drive Constants file work correctly.

Drive Constants is where your robot's specifications are stored and accessed and it is vital these are correct

**Note: this is what worked for me, it may not work for you**

In Drive Constants I have set MaxRpm to whatever the manual says (6000 in my case) multiplied by 1/ gear ratio. So in my case, using the Rev Ultra-planetary motor with a 15:1 gearbox was 400.

I have Gear Ratio set to 1/ gear ratio. So in my case 1/15.

TicksPerRev can be set to your ticks per revolution of your motor as found on the specifications. For me it was 28.

Wheel Radius is the radius of your wheel in inches.

You will need to set your USB facing dir and logo facing dir to the correct direction for your robot. This is the direction the logo on the motor is facing and the direction the USB is facing. Mine are as follows:

```
public static final RevHubOrientationOnRobot.UsbFacingDirection USB_FACING_DIR = RevHubOrientationOnRobot.UsbFacingDirection.LEFT;
public static final RevHubOrientationOnRobot.LogoFacingDirection LOGO_FACING_DIR = RevHubOrientationOnRobot.LogoFacingDirection.UP; 
```

**This all has to be very specific to make it work better**

When tuning trackWidth, I would recommend running it multiple times, and making sure to change the values on [FTC Dashboard](http://192.168.43.1:8080/dash) to make it more accurate.

**Note: when changing anything in the Dashboard MAKE SURE you press enter to save the values and once you are finished, make sure to put all changed values into the correct file**

If you are tuning Manual FeedForward:

When tuning kV make everything else (kP, kA) 0

kV changes the max velocity to make the top of the peak

kA is acceleration(lower = slower acceleration)

kP is fine tuning to make sure it is closer to the path we want it to be at

**Now you should be able to go and just go through the rest of Learn Road Runner and it should work if you have tuned everything properly**

#### Troubleshooting

If the robot is supposed to be going straight, and it isn't, make sure your motor directions are set correctly in SampleMecanumDrive or your tracking localizer
