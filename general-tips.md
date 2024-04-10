# General Tips

### Create a config.md file in your code:

This has saved me so many times with motor and servo naming and where they are supposed to be put. This allows you to have a config map of every single thing you have connected to your robot. This helps with the configuration of the Control Hub as you can just refer to this document. Create this by right clicking on the folder you want it in, add file, name = config.md, and then just copy this text in to the file.

```
Only a template, don't edit this file, copy it and make a new file
Format: # - type : name

Control Hub
Motor
0 -
1 -
2 -
3 -
Encoder (will only be different if a different encoder is in the same slot as a different motor)
0 -
1 -
2 -
3 -
Servo
0 -
1 -
2 -
3 -
4 -
5 -
Digital
0 -
1 -
2 -
3 -
4 -
5 -
6 -
7 -
I2C Bus
0 -
1 -
2 -
3 -
Analog
0 -
1 -
2 -
3 -

RS485 -
USB -

Expansion Hub
Motor
0 -
1 -
2 -
3 -
Encoder
0 -
1 -
2 -
3 -
Servo
0 -
1 -
2 -
3 -
4 -
5 -
Digital
0 -
1 -
2 -
3 -
4 -
5 -
6 -
7 -
I2C Bus
0 -
1 -
2 -
3 -
Analog
0 -
1 -
2 -
3 -

RS485 -
USB - 
```
