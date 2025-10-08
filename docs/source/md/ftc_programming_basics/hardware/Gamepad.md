# Gamepad

Game-pad inputs are the base of teleOp. You can use `if(gamepad1.left_bumper){` to check if it has been pressed. Other game-pad buttons give different inputs. Some will give floats back while some are boolean. You can also use game-pad2 to use a second one. Below is a list of every input and what type it will give back to the robot.

```java
.a boolean
.b boolean
.y boolean
.x boolean
.left_stick_y or x or right float
.right_stick_x or y or left float
.dpad_down boolean
.dpad_up boolean
.dpad_right boolean
.dpad_left boolean
.back boolean
.start boolean
.left_bumper boolean
.right_bumper boolean
.left_stick_button or right boolean
.right_trigger or left float
.touchpad_finger_1_x or y float
```