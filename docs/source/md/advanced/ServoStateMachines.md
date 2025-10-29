# ServoStateMachines

## Overview

State machines for servos are a great way to handle servo operation. It allows you to send commands and then operate the servo based on those commands.

## Code

```java
public enum servo1State {UP, DOWN, MID, IDLE}

private servo1State servo1StateVar = servo1State.IDLE;

public void setservo1StateUP() {
    servo1StateVar = servo1State.UP;
}

public void setservo1StateDOWN() {
    servo1StateVar = servo1State.DOWN;
}

public void setservo1StateMID() {
    servo1StateVar = servo1State.MID;
}

public void setservo1StateIDLE() {
    servo1StateVar = servo1State.IDLE;
}

switch (servo1StateVar) { // needs to be updated every loop
    case UP:
        // Add code here
        break;
    case DOWN:
        // Add code here
        break;
    case MID:
        // Add code here
        break;
    case IDLE:
        // Add code here
        break;
}
```
This prevents the need for multiple if statements and makes the code cleaner and easier to read.
To send a command, you would use the code ```setservo1StateUP();``` to set the servo to the UP state.
This works because you send a command, and then when it gets updated, it will run the code to set the servo to the correct point using enums and a switch case.

**Do not** forget the break, or it will try to do all in one.

An easy way to set this up is to use this [website](https://gramgra07.github.io/gg-web/content/ftcUtils/sm_creator/index.html) I made to generate code for you.