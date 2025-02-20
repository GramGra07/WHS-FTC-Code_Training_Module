# PIDF Controller

## What is it? 

A PIDF controller is a way of controlling the robot's movement using a PIDF loop. This means that it will use the error of a motors position to calculate where it should move to next. It calculates the power of the motor using the error (figured by the encoder) and the tuned PIDF constants. The PIDF constants, being Position, Integral, Derivative, and FeedForward, are used to tune the PIDF loop to make it more accurate.

P: The value multiplied by the error to get the power of the motor. This is the main value that is tuned to make the motor more accurate.

I: The value multiplied by the integral of the error to get the power of the motor. This is used to make sure that the motor is not stuck at a certain position.

D: The value that determines how to react to the change in current errors.

F: This is the value that helps stabilize it against gravity and other forces.

## How do I use it? 

Simply create the PIDFController class and then use the `calculate` function to calculate the power of the motor.

`public static PIDFController pidfController = new PIDFController(0, 0, 0, 0);`

Those constants will then be changed to tune the PIDF loop.

`pidfController.calculate(currentPosition, targetPosition);`

Then apply power to the motor you would like to power.

`motor.setPower(pidfController.calculate(currentPosition, targetPosition));`

This will allow it to automatically calculate the power of the motor.

## How do I tune it? 

To tune this, I would recommend using FTC Dashboard, found [here](https://acmerobotics.github.io/ftc-dashboard/). This will allow you to see the values of the PIDF loop and change them in real time.

Specifically with FTC Dash, it makes it way easier because you can log the values being outputted by the encoder on your motor, and tune the PIDF loop in real time.

Once you get the values you want, you can then put them into your code.

### FTC Dashboard Setup

After you add it to the project, put `@Config` before `@TeleOp` or `@Autonomous`.

Then add the following code to your code:

`public static PIDFCoefficients PIDFCo = new PIDFCoefficients(0, 0, 0, 0);`

`PIDF.setPIDF(PIDFCo.p, PIDFCo.i, PIDFCo.d, PIDFCo.f);`

**Note that this is a little more complex and not needed to tune it, just makes it easier/quicker**

### Tuning steps

1. Set all values to 0
2. Slowly increase P until it starts to stop oscillating back and forth on the target position
3. Slowly increase F until it stops oscillating and gravity is not affecting it

You can then tune I and D to make it more accurate, but I will not cover that in this guide.

## How do I implement it?

### TeleOp

```java
if (gamepad2.right_stick_y < 0 && usePIDF) {
    PIDF.setPIDF(PIDFCo.p, PIDFCo.i, PIDFCo.d, PIDFCo.f);
    Power = Range.clip(PIDF.calculate(motor.getCurrentPosition(), maxTicks), -1, 1);
} else if (gamepad2.right_stick_y > 0 && usePIDF) {
    PIDF.setPIDF(PIDFCo.p, PIDFCo.i, PIDFCo.d, PIDFCo.f);
    Power = Range.clip(PIDF.calculate(motor.getCurrentPosition(), minTicks), -1, 1);
} else {
    Power = 0;
}
if (gamepad2.cross) {
    usePIDF = false;
}
```

In this code, we tell it that if the right stick is pushed up, it will use the PIDF loop to calculate the power of the motor as well as if it is pushed down, the only difference is the target values.

We also have a boolean that will allow us to turn off the PIDF loop if we need to.

### Autonomous

During autonomous usage, you can also use PIDF loops fairly easy with a while loop, or if you are using Road Runner or something else that doesn't allow while loops, State Machines.

#### While loop

```java
while (opModeIsActive()){
    PIDF.setPIDF(PIDFCo.p, PIDFCo.i, PIDFCo.d, PIDFCo.f);
    motor.setPower(PIDF.calculate(motor.getCurrentPosition(), targetPosition));
}
```

You can also switch the target position to a variable that is changed throughout the program.

#### State Machine

More information on State Machines can be found [here](statemachine.md).

In this example, we would set the target as a variable and set that differently throughout the program.

## Resources

[https://youtu.be/E6H6Nqe6qJo?si=luVu2EeaFapRfCl3](https://youtu.be/E6H6Nqe6qJo?si=luVu2EeaFapRfCl3)

[https://cookbook.dairy.foundation/integrating\_a\_custom\_PIDF\_controller.html](https://cookbook.dairy.foundation/integrating\_a\_custom\_PIDF\_controller.html)
